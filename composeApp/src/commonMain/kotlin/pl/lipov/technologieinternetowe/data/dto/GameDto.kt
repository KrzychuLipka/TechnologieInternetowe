package pl.lipov.technologieinternetowe.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
    val userId: Long,
    val id: Long,
    val title: String,
    val completed: Boolean
)
