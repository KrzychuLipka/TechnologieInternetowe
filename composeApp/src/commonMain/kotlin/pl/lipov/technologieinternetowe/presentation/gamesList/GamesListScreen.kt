package pl.lipov.technologieinternetowe.presentation.gamesList

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import pl.lipov.technologieinternetowe.domain.model.Game

@Composable
fun GamesListScreen(
    modifier: Modifier,
    viewModel: GamesListViewModel,
    onGameClick: (Game) -> Unit
) {
    val gamesState = viewModel.games.collectAsState()
    val games = gamesState.value

    LazyRow(
        modifier = modifier
    ) {
        items(games) { game ->
            GameItem(
                game = game,
                onGameClick = onGameClick
            )
        }
    }
}
