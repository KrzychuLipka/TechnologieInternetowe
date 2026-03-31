package pl.lipov.server

@kotlinx.serialization.Serializable
data class CompletedUpdateRequest(
    val completed: Boolean
)
