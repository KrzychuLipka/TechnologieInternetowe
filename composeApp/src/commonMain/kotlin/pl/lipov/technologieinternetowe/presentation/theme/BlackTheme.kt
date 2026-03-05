package pl.lipov.technologieinternetowe.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BlackTheme(content: @Composable () -> Unit) {
    val colors = darkColorScheme(
        background = Color.Black,
        surface = Color.Black,
        surfaceVariant = Color.Black,
        surfaceContainer = Color.Black,
        surfaceContainerHigh = Color.Black,
        surfaceContainerHighest = Color.Black,
        onBackground = Color.White,
        onSurface = Color.White
    )
    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
