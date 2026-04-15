package pl.lipov.technologieinternetowe.domain.model

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val error: String) : ApiResult<Nothing>()
    data object NetworkError : ApiResult<Nothing>()
}
