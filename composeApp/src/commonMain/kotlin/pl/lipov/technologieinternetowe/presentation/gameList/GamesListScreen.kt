package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.common.ui.MagazineUtils
import pl.lipov.technologieinternetowe.presentation.theme.DarkYellow
import pl.lipov.technologieinternetowe.presentation.theme.Dimens
import pl.lipov.technologieinternetowe.presentation.theme.Yellow

@Composable
fun GamesListScreen(
    modifier: Modifier = Modifier,
    magazineNumber: Int,
    onBack: () -> Unit
) {
    val viewModel: GamesListViewModel = viewModel { GamesListViewModel() }

    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(MagazineUtils.getMagazineImage(magazineNumber)),
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
                TextButton(
                    onClick = { onBack() },
                    modifier = Modifier.padding(Dimens.PaddingSmall)
                ) {
                    Text(
                        "POWRÓT",
                        color = Color.Red
                    )
                }
                Text(
                    "RETRO #$magazineNumber",
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(Dimens.PaddingSmall)
                )
            }

            val gamesState = viewModel.getAllGames(magazineNumber).collectAsState()

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                Column(
                    modifier.align(Alignment.BottomCenter)
                ) {

                    Spacer(
                        modifier = Modifier
                            .background(DarkYellow)
                            .fillMaxWidth()
                            .height(Dimens.ShelfTopHeight)
                    )

                    Spacer(
                        modifier = Modifier
                            .background(Yellow)
                            .fillMaxWidth()
                            .height(Dimens.ShelfFrontHeight)
                    )
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxSize()
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
}
