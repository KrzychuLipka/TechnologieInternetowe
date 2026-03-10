package pl.lipov.technologieinternetowe.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.lipov.technologieinternetowe.domain.model.Game

interface GamesRepository {
    fun getAllGames(): Flow<List<Game>>
    suspend fun markAsCompleted(gameId: String)
    suspend fun markAsUncompleted(gameId: String)
}
