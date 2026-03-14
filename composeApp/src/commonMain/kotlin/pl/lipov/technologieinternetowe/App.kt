package pl.lipov.technologieinternetowe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import pl.lipov.technologieinternetowe.presentation.gameList.GamesListScreen
import pl.lipov.technologieinternetowe.presentation.magazineList.MagazineListScreen
import pl.lipov.technologieinternetowe.presentation.theme.appTypography

@Composable
fun App() {
    var selectedMagazineNumber by remember { mutableStateOf<Int?>(null) }
    val gridState = rememberSaveable(saver = LazyGridState.Saver) {
        LazyGridState()
    }

    MaterialTheme(
        typography = appTypography()
    ) {
        Scaffold { padding ->

            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                if (selectedMagazineNumber == null) {
                    MagazineListScreen(
                        gridState = gridState
                    ) { selectedMagazineNumber = it }
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
