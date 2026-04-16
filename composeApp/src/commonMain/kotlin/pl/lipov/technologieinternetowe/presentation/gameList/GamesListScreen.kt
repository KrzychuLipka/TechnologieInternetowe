package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.presentation.UiMessenger
import pl.lipov.technologieinternetowe.presentation.theme.DarkYellow
import pl.lipov.technologieinternetowe.presentation.theme.Dimens
import pl.lipov.technologieinternetowe.presentation.theme.GameBoxSize
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.retro9

private const val MAGAZINE_NUMBER = 9

@Composable
fun GamesListScreen(
    uiMessenger: UiMessenger,
    modifier: Modifier = Modifier,
    magazineNumber: Int = MAGAZINE_NUMBER
) {
    val viewModel: GamesListViewModel = viewModel { GamesListViewModel(uiMessenger) }

    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(Res.drawable.retro9),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { alpha = 0.5f },
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth(),
            ) {
                Text(
                    "CD Action Retro",
                    color = DarkYellow,
                    modifier = Modifier.padding(Dimens.PaddingSmall)
                )
            }
            val gamesState = viewModel.getAllGames(magazineNumber).collectAsState()
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = GameBoxSize)
                ) {
                    items(gamesState.value) { game ->
                        GameItem(
                            game = game,
                            onGameUrlClick = { viewModel.handleGameUrlClick(it) },
                            onRunGameButtonClick = { viewModel.handleRunGameButtonClick(it.id) },
                            onToggleCompletionButtonClick = {
                                viewModel.handleToggleGameCompletionButtonClick(
                                    "invalid_id"// TODO it.id
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
