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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.presentation.theme.DarkYellow
import pl.lipov.technologieinternetowe.presentation.theme.Dimens
import pl.lipov.technologieinternetowe.presentation.theme.GameBoxSize
import pl.lipov.technologieinternetowe.presentation.theme.Yellow
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.crusader_no_remorse
import technologieinternetowe.composeapp.generated.resources.dino_crisis_2
import technologieinternetowe.composeapp.generated.resources.doom
import technologieinternetowe.composeapp.generated.resources.fallout
import technologieinternetowe.composeapp.generated.resources.far_cry
import technologieinternetowe.composeapp.generated.resources.fear
import technologieinternetowe.composeapp.generated.resources.flashback
import technologieinternetowe.composeapp.generated.resources.flight_of_the_amazon_queen
import technologieinternetowe.composeapp.generated.resources.ic_checked
import technologieinternetowe.composeapp.generated.resources.ic_gog
import technologieinternetowe.composeapp.generated.resources.ic_play
import technologieinternetowe.composeapp.generated.resources.ic_unchecked
import technologieinternetowe.composeapp.generated.resources.jazz_jackrabbit_2
import technologieinternetowe.composeapp.generated.resources.medal_of_honor
import technologieinternetowe.composeapp.generated.resources.mortal_kombat
import technologieinternetowe.composeapp.generated.resources.moto_racer
import technologieinternetowe.composeapp.generated.resources.prehistorik_2
import technologieinternetowe.composeapp.generated.resources.prince_of_persia
import technologieinternetowe.composeapp.generated.resources.psychonauts
import technologieinternetowe.composeapp.generated.resources.rayman
import technologieinternetowe.composeapp.generated.resources.rayman_origins
import technologieinternetowe.composeapp.generated.resources.red_faction
import technologieinternetowe.composeapp.generated.resources.rollercoaster_tycoon
import technologieinternetowe.composeapp.generated.resources.rune
import technologieinternetowe.composeapp.generated.resources.screamer
import technologieinternetowe.composeapp.generated.resources.ski_jumping_world_cup
import technologieinternetowe.composeapp.generated.resources.star_wars_dark_forces
import technologieinternetowe.composeapp.generated.resources.star_wars_galactic_battlegrounds
import technologieinternetowe.composeapp.generated.resources.streets_of_rage_4
import technologieinternetowe.composeapp.generated.resources.teenagent
import technologieinternetowe.composeapp.generated.resources.tomb_raider

private val gameBoxes = mapOf(
    "streets_of_rage_4" to Res.drawable.streets_of_rage_4,
    "medal_of_honor" to Res.drawable.medal_of_honor,
    "doom" to Res.drawable.doom,
    "rayman" to Res.drawable.rayman,
    "rayman_origins" to Res.drawable.rayman_origins,
    "jazz_jackrabbit_2" to Res.drawable.jazz_jackrabbit_2,
    "prehistorik_2" to Res.drawable.prehistorik_2,
    "psychonauts" to Res.drawable.psychonauts,
    "screamer" to Res.drawable.screamer,
    "moto_racer" to Res.drawable.moto_racer,
    "ski_jumping_world_cup" to Res.drawable.ski_jumping_world_cup,
    "rollercoaster_tycoon" to Res.drawable.rollercoaster_tycoon,
    "fear" to Res.drawable.fear,
    "red_faction" to Res.drawable.red_faction,
    "far_cry" to Res.drawable.far_cry,
    "rune" to Res.drawable.rune,
    "prince_of_persia" to Res.drawable.prince_of_persia,
    "flight_of_the_amazon_queen" to Res.drawable.flight_of_the_amazon_queen,
    "flashback" to Res.drawable.flashback,
    "mortal_kombat" to Res.drawable.mortal_kombat,
    "crusader_no_remorse" to Res.drawable.crusader_no_remorse,
    "star_wars_galactic_battlegrounds" to Res.drawable.star_wars_galactic_battlegrounds,
    "dino_crisis_2" to Res.drawable.dino_crisis_2,
    "tomb_raider" to Res.drawable.tomb_raider,
    "teenagent" to Res.drawable.teenagent,
    "fallout" to Res.drawable.fallout,
    "star_wars_dark_forces" to Res.drawable.star_wars_dark_forces,
)

@Composable
fun GameItem(
    modifier: Modifier = Modifier,
    game: Game,
    onGameUrlClick: (Game) -> Unit,
    onRunGameButtonClick: (Game) -> Unit,
    onToggleCompletionButtonClick: (Game) -> Unit
) {
    val gameBoxRes = gameBoxes.getOrElse(game.id) { Res.drawable.doom }

    Column(modifier) {
        Box {
            Spacer(
                modifier = Modifier
                    .background(Yellow)
                    .fillMaxWidth()
                    .height(Dimens.ShelfDepth)
                    .align(Alignment.BottomCenter)
            )

            Image(
                painter = painterResource(gameBoxRes),
                contentDescription = game.title,
                Modifier
                    .align(Alignment.BottomCenter)
                    .height(GameBoxSize),
                contentScale = ContentScale.FillHeight
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
            Image(
                painter = painterResource(Res.drawable.ic_gog),
                contentDescription = "GOG",
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .clickable { onGameUrlClick(game) }
            )

            Spacer(Modifier.width(Dimens.PaddingStandard))

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