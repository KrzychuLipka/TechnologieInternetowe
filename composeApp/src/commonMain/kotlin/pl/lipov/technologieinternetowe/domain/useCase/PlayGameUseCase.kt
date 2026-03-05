package pl.lipov.technologieinternetowe.domain.useCase

import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class PlayGameUseCase(
    private val repository: GamesRepository
) {

    suspend operator fun invoke(
        gameUrl: String
    ) = repository.playGame(gameUrl)
}
