package pl.lipov.technologieinternetowe.domain.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.awt.Desktop
import java.io.File
import java.io.IOException
import java.net.URI


private const val GAME_FILE_EXTENSION = ".exe"
private const val GAME_DIR = "D:/roms"

actual suspend fun runGame(
    gameId: String
): Result<Unit> = withContext(Dispatchers.IO) {
    val gameFile = File("$GAME_DIR/$gameId$GAME_FILE_EXTENSION")

    if (!gameFile.exists()) {
        return@withContext Result.failure(
            IllegalArgumentException("Game file not found: ${gameFile.absolutePath}")
        )
    }

    try {
        ProcessBuilder(gameFile.absolutePath)
            .directory(gameFile.parentFile)
            .redirectErrorStream(true)
            .start()
        Result.success(Unit)
    } catch (exception: IOException) {
        Result.failure(exception)
    }
}

actual fun openGameUrl(url: String) {
    Desktop.getDesktop().browse(URI(url))
}
