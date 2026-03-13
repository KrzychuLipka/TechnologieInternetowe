package pl.lipov.technologieinternetowe.presentation.magazineList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.common.ui.MagazineUtils
import pl.lipov.technologieinternetowe.presentation.theme.Dimens

@Composable
fun MagazineItem(
    magazineNumber: Int,
    onMagazineNumberSelected: (Int) -> Unit
) {

    Image(
        painter = painterResource(MagazineUtils.getMagazineImage(magazineNumber)),
        contentDescription = "Retro #$magazineNumber",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(Dimens.MagazineMainPageHeight)
            .width(Dimens.MagazineMainPageWidth)
            .clickable {
                onMagazineNumberSelected(magazineNumber)
            }
    )
}
