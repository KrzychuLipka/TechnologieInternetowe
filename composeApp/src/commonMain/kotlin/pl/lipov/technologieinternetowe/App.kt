package pl.lipov.technologieinternetowe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import pl.lipov.technologieinternetowe.presentation.UiEventHandler
import pl.lipov.technologieinternetowe.presentation.UiMessenger
import pl.lipov.technologieinternetowe.presentation.gameList.GamesListScreen
import pl.lipov.technologieinternetowe.presentation.theme.appTypography

@Composable
fun App() {
    val uiMessenger = remember { UiMessenger() }

    MaterialTheme(
        typography = appTypography()
    ) {
        Scaffold { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                GamesListScreen(uiMessenger)
                UiEventHandler(uiMessenger.events)
            }
        }
    }
}
