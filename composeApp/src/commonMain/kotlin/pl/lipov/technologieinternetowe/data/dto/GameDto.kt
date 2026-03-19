package pl.lipov.technologieinternetowe.data.dto

import kotlinx.serialization.Serializable
import pl.lipov.technologieinternetowe.domain.model.Platform

@Serializable
data class GameDto(
    val id: String,
    val title: String,
    val magazineNumber: Int,
    val platform: Platform,
    val gameUrl: String? = null,
    val playable: Boolean = false
)