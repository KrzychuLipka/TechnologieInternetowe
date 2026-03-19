package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.call.body
import io.ktor.client.request.get
import pl.lipov.technologieinternetowe.data.dto.GameDto

object GamesRemoteDataSource {

    suspend fun getAllGames(): List<GameDto> =
        HttpClientProvider
            .httpClient
            .get("/games")
            .body()
}
