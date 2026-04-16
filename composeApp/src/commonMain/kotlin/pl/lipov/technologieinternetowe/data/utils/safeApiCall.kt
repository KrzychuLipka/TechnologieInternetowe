package pl.lipov.technologieinternetowe.data.utils

import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import pl.lipov.technologieinternetowe.data.dto.ErrorResponseDto
import pl.lipov.technologieinternetowe.domain.model.ApiResult

suspend inline fun <reified T> safeApiCall(
    crossinline block: suspend () -> T
): ApiResult<T> {
    return try {
        ApiResult.Success(block())
    } catch (exception: ClientRequestException) {
        val error = exception.response.body<ErrorResponseDto>()
        ApiResult.Error(error.code)
    } catch (exception: ServerResponseException) {
        val error = runCatching { exception.response.body<ErrorResponseDto>() }.getOrNull()
        ApiResult.Error(error?.code ?: "SERVER_ERROR")
    } catch (_: Exception) {
        ApiResult.Error(
            code = "NETWORK_ERROR"
        )
    }
}
