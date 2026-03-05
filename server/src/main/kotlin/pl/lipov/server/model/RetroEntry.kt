package pl.lipov.server.model

import kotlinx.serialization.Serializable

@Serializable
data class RetroEntry(
    val number: Int,
    val games: List<GameEntry>
)