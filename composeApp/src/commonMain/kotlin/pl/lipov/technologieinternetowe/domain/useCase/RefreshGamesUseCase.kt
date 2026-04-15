package pl.lipov.technologieinternetowe.domain.useCase

import pl.lipov.technologieinternetowe.domain.model.ApiResult
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class RefreshGamesUseCase(
    private val repository: GamesRepository
) {

    suspend operator fun invoke(): ApiResult<Unit> = repository.refresh()
}
