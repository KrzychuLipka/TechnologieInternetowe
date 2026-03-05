package pl.lipov.server.model

import kotlinx.serialization.Serializable

@Serializable
data class GameEntry(
    val id: String,
    val title: String,
    val platform: String?,
    val gogUrl: String?,
    val steamUrl: String?,
    val playable: Boolean
)