package pl.lipov.technologieinternetowe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import pl.lipov.technologieinternetowe.presentation.gameList.GamesListScreen
import pl.lipov.technologieinternetowe.presentation.magazineList.MagazineListScreen

@Composable
fun App() {
    var selectedMagazineNumber by remember { mutableStateOf<Int?>(null) }

    MaterialTheme {
        Scaffold { padding ->

            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                if (selectedMagazineNumber == null) {
                    MagazineListScreen { selectedMagazineNumber = it }
                } else {
                    GamesListScreen(
                        magazineNumber = selectedMagazineNumber!!,
                        onBack = { selectedMagazineNumber = null }
                    )
                }
            }
        }
    }
}
