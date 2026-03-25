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
import pl.lipov.technologieinternetowe.domain.model.Platform
import pl.lipov.technologieinternetowe.presentation.theme.DarkYellow
import pl.lipov.technologieinternetowe.presentation.theme.Dimens
import pl.lipov.technologieinternetowe.presentation.theme.Yellow
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.aliens_versus_predator
import technologieinternetowe.composeapp.generated.resources.battle_net
import technologieinternetowe.composeapp.generated.resources.beneath_a_steel_sky
import technologieinternetowe.composeapp.generated.resources.boulder_dash
import technologieinternetowe.composeapp.generated.resources.commander_keen_complete_pack
import technologieinternetowe.composeapp.generated.resources.dino_crisis_2
import technologieinternetowe.composeapp.generated.resources.donkey_kong_country_2
import technologieinternetowe.composeapp.generated.resources.doom
import technologieinternetowe.composeapp.generated.resources.earthworm_jim
import technologieinternetowe.composeapp.generated.resources.far_cry
import technologieinternetowe.composeapp.generated.resources.fear
import technologieinternetowe.composeapp.generated.resources.fire_fight
import technologieinternetowe.composeapp.generated.resources.flashback
import technologieinternetowe.composeapp.generated.resources.flight_of_the_amazon_queen
import technologieinternetowe.composeapp.generated.resources.franko
import technologieinternetowe.composeapp.generated.resources.gta4
import technologieinternetowe.composeapp.generated.resources.half_life
import technologieinternetowe.composeapp.generated.resources.ic_checked
import technologieinternetowe.composeapp.generated.resources.ic_gog
import technologieinternetowe.composeapp.generated.resources.ic_play
import technologieinternetowe.composeapp.generated.resources.ic_steam
import technologieinternetowe.composeapp.generated.resources.ic_unchecked
import technologieinternetowe.composeapp.generated.resources.indiana_jones_and_the_fate_of_atlantis
import technologieinternetowe.composeapp.generated.resources.james_pond_2
import technologieinternetowe.composeapp.generated.resources.jazz_jackrabbit_2
import technologieinternetowe.composeapp.generated.resources.kao
import technologieinternetowe.composeapp.generated.resources.lew_leon
import technologieinternetowe.composeapp.generated.resources.lionheart
import technologieinternetowe.composeapp.generated.resources.max_payne
import technologieinternetowe.composeapp.generated.resources.medal_of_honor
import technologieinternetowe.composeapp.generated.resources.miecze_valdgira
import technologieinternetowe.composeapp.generated.resources.mortal_kombat
import technologieinternetowe.composeapp.generated.resources.moto_racer
import technologieinternetowe.composeapp.generated.resources.painkiller
import technologieinternetowe.composeapp.generated.resources.prehistorik_2
import technologieinternetowe.composeapp.generated.resources.prince_of_persia
import technologieinternetowe.composeapp.generated.resources.qwak
import technologieinternetowe.composeapp.generated.resources.rayman
import technologieinternetowe.composeapp.generated.resources.red_faction
import technologieinternetowe.composeapp.generated.resources.resident_evil
import technologieinternetowe.composeapp.generated.resources.river_raid
import technologieinternetowe.composeapp.generated.resources.robo_cop
import technologieinternetowe.composeapp.generated.resources.rollercoaster_tycoon
import technologieinternetowe.composeapp.generated.resources.ruff_tumble
import technologieinternetowe.composeapp.generated.resources.screamer
import technologieinternetowe.composeapp.generated.resources.skaut
import technologieinternetowe.composeapp.generated.resources.ski_jumping_world_cup
import technologieinternetowe.composeapp.generated.resources.star_wars_dark_forces
import technologieinternetowe.composeapp.generated.resources.star_wars_galactic_battlegrounds
import technologieinternetowe.composeapp.generated.resources.starcraft
import technologieinternetowe.composeapp.generated.resources.streets_of_rage_4
import technologieinternetowe.composeapp.generated.resources.superfrog
import technologieinternetowe.composeapp.generated.resources.teenagent
import technologieinternetowe.composeapp.generated.resources.tomb_raider
import technologieinternetowe.composeapp.generated.resources.tony
import technologieinternetowe.composeapp.generated.resources.traps_treasures
import technologieinternetowe.composeapp.generated.resources.tyrian
import technologieinternetowe.composeapp.generated.resources.wolfenstein_3d
import technologieinternetowe.composeapp.generated.resources.zool_2
import technologieinternetowe.composeapp.generated.resources.colin
import technologieinternetowe.composeapp.generated.resources.nfs3

private val gameBoxes = mapOf(
    "franko" to Res.drawable.franko,
    "streets_of_rage_4" to Res.drawable.streets_of_rage_4,
    "medal_of_honor" to Res.drawable.medal_of_honor,
    "half_life" to Res.drawable.half_life,
    "robo_cop" to Res.drawable.robo_cop,
    "wolfenstein_3d" to Res.drawable.wolfenstein_3d,
    "doom" to Res.drawable.doom,
    "commander_keen_complete_pack" to Res.drawable.commander_keen_complete_pack,
    "earthworm_jim" to Res.drawable.earthworm_jim,
    "rayman" to Res.drawable.rayman,
    "jazz_jackrabbit_2" to Res.drawable.jazz_jackrabbit_2,
    "prehistorik_2" to Res.drawable.prehistorik_2,
    "superfrog" to Res.drawable.superfrog,
    "james_pond_2" to Res.drawable.james_pond_2,
    "ruff_tumble" to Res.drawable.ruff_tumble,
    "traps_treasures" to Res.drawable.traps_treasures,
    "zool_2" to Res.drawable.zool_2,
    "qwak" to Res.drawable.qwak,
    "lionheart" to Res.drawable.lionheart,
    "donkey_kong_country_2" to Res.drawable.donkey_kong_country_2,
    "screamer" to Res.drawable.screamer,
    "moto_racer" to Res.drawable.moto_racer,
    "ski_jumping_world_cup" to Res.drawable.ski_jumping_world_cup,
    "rollercoaster_tycoon" to Res.drawable.rollercoaster_tycoon,
    "resident_evil" to Res.drawable.resident_evil,
    "fear" to Res.drawable.fear,
    "aliens_versus_predator" to Res.drawable.aliens_versus_predator,
    "painkiller" to Res.drawable.painkiller,
    "red_faction" to Res.drawable.red_faction,
    "far_cry" to Res.drawable.far_cry,
    "beneath_a_steel_sky" to Res.drawable.beneath_a_steel_sky,
    "indiana_jones_and_the_fate_of_atlantis" to Res.drawable.indiana_jones_and_the_fate_of_atlantis,
    "prince_of_persia" to Res.drawable.prince_of_persia,
    "flight_of_the_amazon_queen" to Res.drawable.flight_of_the_amazon_queen,
    "flashback" to Res.drawable.flashback,
    "mortal_kombat" to Res.drawable.mortal_kombat,
    "star_wars_galactic_battlegrounds" to Res.drawable.star_wars_galactic_battlegrounds,
    "dino_crisis_2" to Res.drawable.dino_crisis_2,
    "tomb_raider" to Res.drawable.tomb_raider,
    "teenagent" to Res.drawable.teenagent,
    "max_payne" to Res.drawable.max_payne,
    "gta4" to Res.drawable.gta4,
    "star_wars_dark_forces" to Res.drawable.star_wars_dark_forces,
    "boulder_dash" to Res.drawable.boulder_dash,
    "river_raid" to Res.drawable.river_raid,
    "miecze_valdgira" to Res.drawable.miecze_valdgira,
    "tony" to Res.drawable.tony,
    "lew_leon" to Res.drawable.lew_leon,
    "fire_fight" to Res.drawable.fire_fight,
    "skaut" to Res.drawable.skaut,
    "kao" to Res.drawable.kao,
    "tyrian" to Res.drawable.tyrian,
    "starcraft" to Res.drawable.starcraft,
    "colin" to Res.drawable.colin,
    "nfs3" to Res.drawable.nfs3,
)

@Composable
fun GameItem(
    modifier: Modifier = Modifier,
    game: Game,
    onGameUrlClick: (String) -> Unit,
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
                    .height(Dimens.GameBoxSize),
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