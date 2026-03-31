package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.model.Platform
import pl.lipov.technologieinternetowe.presentation.theme.DarkYellow
import pl.lipov.technologieinternetowe.presentation.theme.Dimens
import pl.lipov.technologieinternetowe.presentation.theme.Yellow
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.battle_net
import technologieinternetowe.composeapp.generated.resources.ic_checked
import technologieinternetowe.composeapp.generated.resources.ic_gog
import technologieinternetowe.composeapp.generated.resources.ic_play
import technologieinternetowe.composeapp.generated.resources.ic_steam
import technologieinternetowe.composeapp.generated.resources.ic_unchecked

@Composable
fun GameItem(
    modifier: Modifier = Modifier,
    game: Game,
    onGameUrlClick: (String) -> Unit,
    onRunGameButtonClick: (Game) -> Unit,
    onToggleCompletionButtonClick: (Game) -> Unit
) {
    Column(modifier) {
        Box {
            Spacer(
                modifier = Modifier
                    .background(Yellow)
                    .fillMaxWidth()
                    .height(Dimens.ShelfDepth)
                    .align(Alignment.BottomCenter)
            )

            BoxImage(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(Dimens.GameBoxSize),
                game = game
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkYellow)
                .padding(Dimens.PaddingSmall),
        ) {
            val gameUrl = game.gameUrl
            if (!gameUrl.isNullOrBlank()) {
                val iconRes = when (game.platform) {
                    Platform.BATTLE_NET -> Res.drawable.battle_net
                    Platform.GOG -> Res.drawable.ic_gog
                    else -> Res.drawable.ic_steam
                }
                Image(
                    painter = painterResource(iconRes),
                    contentDescription = "Game web page",
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .clickable { onGameUrlClick(gameUrl) }
                )

                Spacer(Modifier.width(Dimens.PaddingStandard))
            }

            if (game.playable) {
                Image(
                    painter = painterResource(Res.drawable.ic_play),
                    contentDescription = "Play",
                    modifier = Modifier
                        .padding(horizontal = Dimens.PaddingStandard)
                        .width(32.dp)
                        .height(32.dp)
                        .clickable { onRunGameButtonClick(game) }
                )

                Spacer(Modifier.width(Dimens.PaddingStandard))
            }

            val completionButton =
                if (game.completed) Res.drawable.ic_checked else Res.drawable.ic_unchecked

            Image(
                painter = painterResource(completionButton),
                contentDescription = "Completion",
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .clickable { onToggleCompletionButtonClick(game) }
            )
        }
    }
}