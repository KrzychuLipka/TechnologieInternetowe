package pl.lipov.technologieinternetowe.domain.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.awt.Desktop
import java.io.IOException
import java.net.URI
import kotlin.io.path.createTempFile

private const val GAME_FILE_EXTENSION = ".exe"

actual suspend fun runGame(
    gameId: String
): Result<Unit> = withContext(Dispatchers.IO) {
    val gameFileName = "$gameId${GAME_FILE_EXTENSION}"

    try {
        val inputStream = {}::class.java.classLoader
            ?.getResourceAsStream(gameFileName)
            ?: return@withContext Result.failure(
                IllegalArgumentException("Resource $gameFileName not found")
            )

        val gameTempFile = createTempFile(gameId, GAME_FILE_EXTENSION).toFile()
        gameTempFile.deleteOnExit()
        gameTempFile.outputStream().use { output ->
            inputStream.copyTo(output)
        }
        gameTempFile.setExecutable(true)

        ProcessBuilder(gameTempFile.absolutePath).start()

        Result.success(Unit)
    } catch (exception: IOException) {
        Result.failure(exception)
    }
}

actual fun openGameUrl(
    url: String
) {
    Desktop.getDesktop().browse(URI(url))
}
