package pl.lipov.technologieinternetowe.domain.utils

import kotlinx.browser.window

actual suspend fun runGame(
    gameId: String
): Result<Unit> {
    window.alert("W celu zagrania w wybraną grę musisz skorzystać z desktopowej wersji aplikacji.")
    return Result.success(Unit)
}

actual fun openGameUrl(
    url: String
) {
    try {
        window.open(url, "_blank")
    } catch (_: Throwable) {
        window.alert("Nie udało się otworzyć linku.")
    }
}
