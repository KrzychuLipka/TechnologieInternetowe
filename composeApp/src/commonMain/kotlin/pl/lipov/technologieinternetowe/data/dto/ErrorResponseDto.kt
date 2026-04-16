package pl.lipov.technologieinternetowe.data.dto

import kotlinx.serialization.Serializable

@Serializable
class ErrorResponseDto(
    val code: String,
    val message: String
) {
}
