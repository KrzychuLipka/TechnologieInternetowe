package pl.lipov.technologieinternetowe.domain.utils

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.net.toUri

actual suspend fun runGame(
    gameId: String
): Result<Unit> {
    val context =  PlatformContextProvider.context() as? Context
        ?: return Result.failure(
            IllegalArgumentException("Android Context is required")
        )

    Toast.makeText(
        context,
        "W celu zagrania w wybraną grę musisz skorzystać z desktopowej wersji aplikacji.",
        Toast.LENGTH_LONG
    ).show()

    return Result.success(Unit)
}

actual fun openGameUrl(
    url: String
) {
    val context =  PlatformContextProvider.context() as? Context ?: return

    try {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    } catch (exception: Exception) {
        Log.e("GameLauncher.android", exception.localizedMessage, exception)
        Toast.makeText(
            context,
            "Nie udało się otworzyć linku.",
            Toast.LENGTH_SHORT
        ).show()
    }
}
