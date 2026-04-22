package pl.lipov.technologieinternetowe.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.lipov.technologieinternetowe.data.dataSource.PositioningLocalDataSource
import pl.lipov.technologieinternetowe.domain.model.ApiResult
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GamesLocalRepository : GamesRepository {

    override fun getAllGames(
        magazineNumber: Int
    ): Flow<List<Game>> = PositioningLocalDataSource
        .games
        .map { games ->
            games.filter { it.magazineNumber == magazineNumber }
        }

    override suspend fun toggleGameCompletion(gameId: String): ApiResult<Unit> {
        return ApiResult.Success(
            PositioningLocalDataSource.toggleGameCompletion(gameId)
        )
    }

    override suspend fun refresh(): ApiResult<Unit> {
        return ApiResult.Success(Unit)
    }
}
