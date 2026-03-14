package pl.lipov.technologieinternetowe.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.comix_regular

@Composable
fun appTypography(): Typography {
    val comicFont = FontFamily(
        Font(
            Res.font.comix_regular,
            weight = FontWeight.Normal
        )
    )

    val base = Typography()

    return Typography(
        displayLarge = base.displayLarge.copy(fontFamily = comicFont),
        displayMedium = base.displayMedium.copy(fontFamily = comicFont),
        displaySmall = base.displaySmall.copy(fontFamily = comicFont),

        headlineLarge = base.headlineLarge.copy(fontFamily = comicFont),
        headlineMedium = base.headlineMedium.copy(fontFamily = comicFont),
        headlineSmall = base.headlineSmall.copy(fontFamily = comicFont),

        titleLarge = base.titleLarge.copy(fontFamily = comicFont, fontSize = Dimens.FontLarge),
        titleMedium = base.titleMedium.copy(fontFamily = comicFont),
        titleSmall = base.titleSmall.copy(fontFamily = comicFont),

        bodyLarge = base.bodyLarge.copy(fontFamily = comicFont, fontSize = Dimens.FontMedium),
        bodyMedium = base.bodyMedium.copy(fontFamily = comicFont),
        bodySmall = base.bodySmall.copy(fontFamily = comicFont),

        labelLarge = base.labelLarge.copy(fontFamily = comicFont),
        labelMedium = base.labelMedium.copy(fontFamily = comicFont),
        labelSmall = base.labelSmall.copy(fontFamily = comicFont),
    )
}
