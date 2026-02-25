package pl.lipov.technologieinternetowe.domain.model

import org.jetbrains.compose.resources.DrawableResource

data class Game(
    val id: String,
    val title: String,
    val platforms: List<Platform>,
    val imageRes: DrawableResource,
    val gogUrl: String? = null
)
