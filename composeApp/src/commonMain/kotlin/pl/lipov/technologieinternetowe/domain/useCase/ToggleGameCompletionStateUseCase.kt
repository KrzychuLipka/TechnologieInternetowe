package pl.lipov.technologieinternetowe.domain.useCase

import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class ToggleGameCompletionStateUseCase(
    private val repository: GamesRepository
) {

    suspend operator fun invoke(
        game: Game
    ) {
        if (game.completed) {
            repository.markAsUncompleted(game.id)
        } else {
            repository.markAsCompleted(game.id)
        }
    }
}
