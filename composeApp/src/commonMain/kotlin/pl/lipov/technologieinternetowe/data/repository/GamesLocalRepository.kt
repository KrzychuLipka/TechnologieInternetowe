package pl.lipov.technologieinternetowe.data.repository

import kotlinx.coroutines.flow.Flow
import pl.lipov.technologieinternetowe.data.dataSource.GamesLocalDataSource
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GamesLocalRepository : GamesRepository {

    override fun getAllGames(): Flow<List<Game>> = GamesLocalDataSource.games

    override suspend fun toggleGameCompletion(
        gameId: String
    ) {
        GamesLocalDataSource.toggleGameCompletion(gameId)
    }
}
