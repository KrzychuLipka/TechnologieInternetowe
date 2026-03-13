package pl.lipov.technologieinternetowe.common.ui

import org.jetbrains.compose.resources.DrawableResource
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.retro1
import technologieinternetowe.composeapp.generated.resources.retro2
import technologieinternetowe.composeapp.generated.resources.retro3
import technologieinternetowe.composeapp.generated.resources.retro4
import technologieinternetowe.composeapp.generated.resources.retro5
import technologieinternetowe.composeapp.generated.resources.retro6
import technologieinternetowe.composeapp.generated.resources.retro7
import technologieinternetowe.composeapp.generated.resources.retro8
import technologieinternetowe.composeapp.generated.resources.retro9

object MagazineUtils {

    private val magazineMainPages = mapOf(
        1 to Res.drawable.retro1,
        2 to Res.drawable.retro2,
        3 to Res.drawable.retro3,
        4 to Res.drawable.retro4,
        5 to Res.drawable.retro5,
        6 to Res.drawable.retro6,
        7 to Res.drawable.retro7,
        8 to Res.drawable.retro8,
        9 to Res.drawable.retro9
    )

    fun getMagazineImage(
        magazineNumber: Int
    ): DrawableResource = magazineMainPages.getOrElse(magazineNumber) { Res.drawable.retro1 }
}
