package pl.lipov.technologieinternetowe.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CompletedUpdateRequest(
    val completed: Boolean
)
