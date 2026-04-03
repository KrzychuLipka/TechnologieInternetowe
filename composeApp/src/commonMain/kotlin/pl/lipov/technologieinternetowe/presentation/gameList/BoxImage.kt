package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.rememberImagePainter
import pl.lipov.technologieinternetowe.domain.model.Game

@Composable
fun BoxImage(
    modifier: Modifier = Modifier,
    game: Game,
    contentScale: ContentScale = ContentScale.FillHeight
) {
    val imageUrl = "TODO/${game.id}.png"
    val painter = rememberImagePainter(imageUrl)
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = game.title,
        contentScale = contentScale
    )
}
