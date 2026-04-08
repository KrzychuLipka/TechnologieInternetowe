package pl.lipov.server.application.dto

import kotlinx.serialization.Serializable

@Serializable
data class GameCompletedUpdateRequest(
    val completed: Boolean
)
