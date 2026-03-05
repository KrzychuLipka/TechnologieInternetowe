package pl.lipov.technologieinternetowe.domain.repository

import pl.lipov.technologieinternetowe.domain.model.Game

interface GamesRepository {
    suspend fun getAllGames(
        magazineNumber: Int
    ): List<Game>
    suspend fun playGame(
        gameUrl: String
    )
}
