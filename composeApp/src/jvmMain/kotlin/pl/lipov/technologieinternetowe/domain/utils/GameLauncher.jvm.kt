package pl.lipov.technologieinternetowe.domain.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.awt.Desktop
import java.io.File
import java.io.IOException
import java.net.URI

private const val GAME_DIR = "D:/roms"

actual suspend fun runGame(
    gameId: String
): Result<Unit> = withContext(Dispatchers.IO) {

    val gameDirectory = File("$GAME_DIR/$gameId")

    if (!gameDirectory.exists() || !gameDirectory.isDirectory) {
        return@withContext Result.failure(
            IllegalArgumentException(
                "Game directory not found: ${gameDirectory.absolutePath}"
            )
        )
    }

    try {
        Desktop.getDesktop().open(gameDirectory)
        Result.success(Unit)
    } catch (exception: IOException) {
        Result.failure(exception)
    }
}

actual fun openGameUrl(url: String) {
    Desktop.getDesktop().browse(URI(url))
}
