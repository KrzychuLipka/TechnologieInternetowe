package pl.lipov.technologieinternetowe.data.repository

import pl.lipov.technologieinternetowe.data.dataSource.GamesRemoteDataSource
import pl.lipov.technologieinternetowe.data.mapper.toGame
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GamesRemoteRepository : GamesRepository {

    override suspend fun getAllGames(
        magazineNumber: Int
    ): List<Game> =
        GamesRemoteDataSource
            .getAllGames(magazineNumber)
            .map { it.toGame() }

    override suspend fun playGame(
        gameUrl: String
    ) = GamesRemoteDataSource.playGame(gameUrl)
}
