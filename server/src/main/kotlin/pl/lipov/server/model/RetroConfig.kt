package pl.lipov.server.model

import kotlinx.serialization.Serializable

@Serializable
data class RetroConfig(
    val retro: List<RetroEntry>
)
