package pl.lipov.technologieinternetowe.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
    val id: String,
    val title: String,
    val gogUrl: String? = null,
    val steamUrl: String? = null,
    val gameUrl: String? = null,
    val playable: Boolean = false
)
