package pl.lipov.technologieinternetowe.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.lipov.technologieinternetowe.domain.model.ApiResult
import pl.lipov.technologieinternetowe.domain.model.Game

interface GamesRepository {
    fun getAllGames(magazineNumber: Int): Flow<List<Game>>
    suspend fun toggleGameCompletion(gameId: String): ApiResult<Unit>
    suspend fun refresh(): ApiResult<Unit>
}