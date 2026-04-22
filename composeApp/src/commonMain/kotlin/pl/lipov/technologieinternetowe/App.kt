package pl.lipov.technologieinternetowe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.lipov.technologieinternetowe.presentation.MapView
import pl.lipov.technologieinternetowe.presentation.theme.appTypography

@Composable
fun App() {
    MaterialTheme(
        typography = appTypography()
    ) {
        Scaffold { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                MapView()
            }
        }
    }
}
