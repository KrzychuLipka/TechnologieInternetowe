package pl.lipov.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id: String,
    val title: String,
    val gogUrl: String?,
    val steamUrl: String?,
    val gameUrl: String?,
    val playable: Boolean
)
