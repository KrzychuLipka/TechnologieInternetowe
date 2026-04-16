package pl.lipov.technologieinternetowe.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import pl.lipov.technologieinternetowe.data.dataSource.GamesRemoteDataSource
import pl.lipov.technologieinternetowe.data.mapper.toGame
import pl.lipov.technologieinternetowe.data.utils.safeApiCall
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
        val game = _games.value
            .find { it.id == gameId }
            ?: return ApiResult.Error(code = "GAME_NOT_FOUND")
        return safeApiCall {
            GamesRemoteDataSource
                .toggleGameCompletedStatus(
                    gameId = gameId,
                    completed = !game.completed
                )
            _games.value = _games.value.map {
                if (it.id == gameId) it.copy(completed = !it.completed)
                else it
            }
        }
    }

    override suspend fun refresh(): ApiResult<Unit> {
        return when (val result = safeApiCall {
            GamesRemoteDataSource.getAllGames()
        }) {
            is ApiResult.Success -> {
                _games.value = result.data.map { it.toGame() }
                ApiResult.Success(Unit)
            }

            is ApiResult.Error -> result
        }
    }
}
