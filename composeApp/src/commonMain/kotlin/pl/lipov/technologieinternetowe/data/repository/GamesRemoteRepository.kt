package pl.lipov.technologieinternetowe.data.repository

import pl.lipov.technologieinternetowe.data.dataSource.GamesRemoteDataSource
import pl.lipov.technologieinternetowe.data.mapper.toGame
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GamesRemoteRepository : GamesRepository {

    override suspend fun getAllGames(): List<Game> =
        GamesRemoteDataSource
            .getGames()
            .map { it.toGame() }

    override suspend fun getGameDetails(
        id: String
    ): Game? = null
}
