package pl.lipov.technologieinternetowe.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import pl.lipov.technologieinternetowe.domain.model.Game

interface GamesRepository {
    fun getAllGames(magazineNumber: Int): Flow<List<Game>>
    suspend fun toggleGameCompletion(gameId: String)
    suspend fun refresh()
}
