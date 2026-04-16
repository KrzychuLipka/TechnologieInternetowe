package pl.lipov.technologieinternetowe.domain.model

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(
        val code: String
    ) : ApiResult<Nothing>()
}
