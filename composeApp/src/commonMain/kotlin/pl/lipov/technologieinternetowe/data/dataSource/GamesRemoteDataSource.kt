package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import pl.lipov.technologieinternetowe.data.dto.CompletedUpdateRequest
import pl.lipov.technologieinternetowe.data.dto.GameDto

object GamesRemoteDataSource {

    suspend fun getAllGames(): List<GameDto> =
        HttpClientProvider
            .httpClient
            .get("/games")
            .body()

    suspend fun toggleGameCompletedStatus(
        gameId: String,
        completed: Boolean
    ) {
        HttpClientProvider
            .httpClient
            .patch("/games/$gameId/completed") {
                contentType(ContentType.Application.Json)
                setBody(CompletedUpdateRequest(completed))
            }
    }
}
