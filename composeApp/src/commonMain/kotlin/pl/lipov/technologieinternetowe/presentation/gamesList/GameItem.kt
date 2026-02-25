package pl.lipov.technologieinternetowe.presentation.gamesList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.presentation.theme.Bronze
import pl.lipov.technologieinternetowe.presentation.theme.Dimens

@Composable
fun GameItem(
    game: Game,
    onGameClick: (Game) -> Unit
) {

    val platformsText = remember(game.platforms) {
        game.platforms.joinToString(" | ") { it.name }
    }

    Column {

        Image(
            painter = painterResource(game.imageRes),
            contentDescription = game.title,
            modifier = Modifier
                .height(Dimens.GameBoxHeight)
                .width(Dimens.GameBoxWidth)
                .clickable { onGameClick(game) }
        )

        Box(
            modifier = Modifier
                .background(Bronze)
                .width(Dimens.GameBoxWidth)
                .padding(vertical = Dimens.PaddingSmall),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = platformsText,
                color = Color.Yellow,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
