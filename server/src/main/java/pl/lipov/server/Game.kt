package pl.lipov.server

import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id: String,
    val title: String,
    val platform: Platform,
    val gameUrl: String? = null,
    val completed: Boolean = false,
    val playable: Boolean = false
)
