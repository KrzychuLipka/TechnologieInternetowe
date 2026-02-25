package pl.lipov.technologieinternetowe.domain.repository

import pl.lipov.technologieinternetowe.domain.model.Game

interface GamesRepository {
    suspend fun getAllGames(): List<Game>
    suspend fun getGameDetails(id: String): Game?
}
