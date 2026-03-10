package pl.lipov.technologieinternetowe.domain.utils

expect suspend fun runGame(
    gameId: String
): Result<Unit>

expect fun openGameUrl(
    url: String
)
