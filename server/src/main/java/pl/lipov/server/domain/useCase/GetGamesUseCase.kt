package pl.lipov.server.domain.useCase

import pl.lipov.server.domain.model.Game
import pl.lipov.server.domain.repository.GameRepository

class GetGamesUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(): List<Game> = repository.getAll()
}
