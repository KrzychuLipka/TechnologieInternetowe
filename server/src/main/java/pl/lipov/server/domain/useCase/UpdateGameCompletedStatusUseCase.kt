package pl.lipov.server.domain.useCase

import pl.lipov.server.domain.error.NotFoundException
import pl.lipov.server.domain.error.ValidationException
import pl.lipov.server.domain.repository.GameRepository

class UpdateGameCompletedStatusUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(id: String, completed: Boolean) {

        if (id.isBlank()) {
            throw ValidationException("ID cannot be blank")
        }

        val updated = repository.updateGameCompletedStatus(id, completed)

        if (!updated) {
            throw NotFoundException("Game with id=$id not found")
        }
    }
}
