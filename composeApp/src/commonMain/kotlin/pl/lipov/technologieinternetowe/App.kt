package pl.lipov.technologieinternetowe

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.lipov.technologieinternetowe.presentation.gamesList.GamesListScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold { padding ->
            GamesListScreen(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(), onGameClick = { }
            )
        }
    }
}
