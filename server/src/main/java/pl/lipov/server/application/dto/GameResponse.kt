package pl.lipov.server.application.dto

import kotlinx.serialization.Serializable
import pl.lipov.server.domain.model.Platform

@Serializable
data class GameResponse(
    val id: String,
    val title: String,
    val platform: Platform,
    val gameUrl: String,
    val playable: Boolean,
    val completed: Boolean
)
