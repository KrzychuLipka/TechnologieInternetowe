package pl.lipov.technologieinternetowe.domain.useCase

import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GetAllGamesUseCase(
    private val repository: GamesRepository
) {

    suspend operator fun invoke(): List<Game> = repository.getAllGames()
}
