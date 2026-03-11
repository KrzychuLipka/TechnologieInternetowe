package pl.lipov.technologieinternetowe.domain.useCase

import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class ToggleGameCompletionStateUseCase(
    private val repository: GamesRepository
) {

    suspend operator fun invoke(
        gameId: String
    ) {
        repository.toggleGameCompletion(gameId)
    }
}
