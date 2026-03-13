package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.common.ui.MagazineUtils
import pl.lipov.technologieinternetowe.presentation.theme.Dimens
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.ic_back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesListScreen(
    modifier: Modifier = Modifier,
    magazineNumber: Int,
    onBack: () -> Unit
) {
    val viewModel: GamesListViewModel = viewModel { GamesListViewModel() }

    Box {
        Image(
            painter = painterResource(MagazineUtils.getMagazineImage(magazineNumber)),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { alpha = 0.5f },
            contentScale = ContentScale.Crop
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("Retro #$magazineNumber") },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageResource(Res.drawable.ic_back),
                                contentDescription = "Powrót"
                            )
                        }
                    }
                )
            }
        ) { padding ->
            val gamesState = viewModel.getAllGames(magazineNumber).collectAsState()

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = Dimens.GameBoxWidth),
                modifier = modifier.padding(padding)
            ) {
                items(gamesState.value) { game ->
                    GameItem(
                        game = game,
                        onGameUrlClick = {
                            viewModel.handleGameUrlClick(it.gogUrl)
                        },
                        onRunGameButtonClick = {
                            viewModel.handleRunGameButtonClick(it.id)
                        },
                        onToggleCompletionButtonClick = {
                            viewModel.handleToggleGameCompletionButtonClick(it.id)
                        }
                    )
                }
            }
        }
    }
}
