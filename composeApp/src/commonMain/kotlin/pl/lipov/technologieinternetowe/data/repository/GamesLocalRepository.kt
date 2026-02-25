package pl.lipov.technologieinternetowe.data.repository

import pl.lipov.technologieinternetowe.data.dataSource.GamesLocalDataSource
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GamesLocalRepository : GamesRepository {

    override suspend fun getAllGames(): List<Game> = GamesLocalDataSource.games

    override suspend fun getGameDetails(
        id: String
    ): Game? = GamesLocalDataSource.getGameById(id)
}
