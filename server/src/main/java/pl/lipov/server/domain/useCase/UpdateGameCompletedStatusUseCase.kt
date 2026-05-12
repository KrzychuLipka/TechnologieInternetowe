package pl.lipov.server.domain.useCase

import pl.lipov.server.domain.repository.GameRepository

class UpdateGameCompletedStatusUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(
        id: String,
        completed: Boolean
    ) {
        repository.updateGameCompletedStatus(id, completed)
    }
}
