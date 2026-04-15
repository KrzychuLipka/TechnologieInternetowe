package pl.lipov.technologieinternetowe.data.repository

import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.io.IOException
import pl.lipov.technologieinternetowe.data.dataSource.GamesRemoteDataSource
import pl.lipov.technologieinternetowe.data.mapper.toGame
import pl.lipov.technologieinternetowe.domain.model.ApiResult
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GamesRemoteRepository : GamesRepository {

    private val _games = MutableStateFlow<List<Game>>(emptyList())

    override fun getAllGames(
        magazineNumber: Int
    ): Flow<List<Game>> =
        _games.map { list ->
            list.filter { it.magazineNumber == magazineNumber }
        }

    override suspend fun toggleGameCompletion(
        gameId: String
    ): ApiResult<Unit> {
        val game = _games.value.find { it.id == gameId }
            ?: return ApiResult.Error("Game not found")

        val newCompletedValue = !game.completed

        return try {
            GamesRemoteDataSource.toggleGameCompletedStatus(
                gameId = gameId,
                completed = newCompletedValue
            )

            _games.value = _games.value.map {
                if (it.id == gameId) it.copy(completed = newCompletedValue)
                else it
            }

            ApiResult.Success(Unit)

        } catch (e: Exception) {
            mapException(e)
        }
    }

    private suspend fun mapException(
        exception: Exception
    ): ApiResult<Unit> {
        return when (exception) {

            is IOException -> {
                ApiResult.NetworkError
            }

            is ClientRequestException -> {
                val error = parseError(exception.response)
                ApiResult.Error(mapApiError(error))
            }

            is ServerResponseException -> {
                ApiResult.Error("Błąd serwera")
            }

            else -> {
                ApiResult.Error("Nieznany błąd")
            }
        }
    }

    private suspend fun parseError(
        response: HttpResponse
    ): String {
        return try {
            response.body()
        } catch (exception: Exception) {
            println(exception.message)
            "Unknown error"
        }
    }

    private fun mapApiError(
        errorCode: String
    ): String {
        return when (errorCode) {
            "NOT_FOUND" -> "Gra nie istnieje"
            "VALIDATION_ERROR" -> "Błąd walidacji"
            "BAD_REQUEST" -> "Nieprawidłowe żądanie"
            else -> "Nieznany błąd"
        }
    }

    override suspend fun refresh(): ApiResult<Unit> {
        return try {
            val remoteGames = GamesRemoteDataSource.getAllGames()
            _games.value = remoteGames.map { it.toGame() }

            ApiResult.Success(Unit)
        } catch (exception: Exception) {
            mapException(exception)
        }
    }
}
