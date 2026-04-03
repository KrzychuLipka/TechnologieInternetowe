package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.domain.model.Game
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.retro9

@Composable
fun BoxImage(
    modifier: Modifier = Modifier,
    game: Game,
    contentScale: ContentScale = ContentScale.FillHeight
) {
    val lowerCaseUrl =
        "https://raw.githubusercontent.com/KrzychuLipka/TechnologieInternetowe/final/boxes/${game.id}.png"
    val upperCaseUrl =
        "https://raw.githubusercontent.com/KrzychuLipka/TechnologieInternetowe/final/boxes/${game.id}.PNG"

    var useUpperCase by remember { mutableStateOf(false) }

    val painter = rememberImagePainter(
        url = if (useUpperCase) upperCaseUrl else lowerCaseUrl,
        errorPainter = {
            if (!useUpperCase) {
                useUpperCase = true
            }

            painterResource(Res.drawable.retro9)
        }
    )

    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = game.title,
        contentScale = contentScale
    )
}