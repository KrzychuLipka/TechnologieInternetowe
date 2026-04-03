package pl.lipov.server

import kotlinx.serialization.Serializable

@Serializable
data class GameUpdateRequest(
    val title: String? = null,
    val platform: Platform? = null,
    val playable: Boolean? = null,
    val completed: Boolean? = null
)

