package pl.lipov.technologieinternetowe.domain.useCase

import kotlinx.coroutines.flow.Flow
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GetAllGamesUseCase(
    private val repository: GamesRepository
) {

    operator fun invoke(): Flow<List<Game>> = repository.getAllGames()
}
