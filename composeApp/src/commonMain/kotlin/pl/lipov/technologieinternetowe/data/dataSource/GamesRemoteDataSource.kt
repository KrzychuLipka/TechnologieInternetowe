package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.call.body
import io.ktor.client.request.get
import pl.lipov.technologieinternetowe.data.dto.GameDto

object GamesRemoteDataSource {

    suspend fun getGames(): List<GameDto> = HttpClientProvider
        .httpClient
        .get("/todos")
        .body()
}
