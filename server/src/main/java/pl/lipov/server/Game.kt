package pl.lipov.server

import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id: String,
    val title: String,
    val magazineNumber: Int,
    val platform: Platform,
    val gameUrl: String? = null,
    val lastPlayed: Int? = null,
    val completed: Boolean = false,
    val playable: Boolean = false
)
