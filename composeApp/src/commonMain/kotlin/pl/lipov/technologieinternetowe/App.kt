package pl.lipov.technologieinternetowe

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.lipov.technologieinternetowe.presentation.discCoverMenu.DiscCoverScreen
import pl.lipov.technologieinternetowe.presentation.theme.BlackTheme

@Composable
@Preview
fun App() {
    BlackTheme {
        Scaffold { padding ->
            DiscCoverScreen(
                modifier = Modifier.padding(padding)
            )
        }
    }
}
