package pl.lipov.server.domain.useCase

data class GameUseCases(
    val getGames: GetGamesUseCase,
    val updateGameCompletedStatus: UpdateGameCompletedStatusUseCase
)
