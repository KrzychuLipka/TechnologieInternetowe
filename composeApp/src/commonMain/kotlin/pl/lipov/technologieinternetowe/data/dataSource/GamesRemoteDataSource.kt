package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import pl.lipov.technologieinternetowe.data.dto.GameDto

object GamesRemoteDataSource {

    suspend fun getAllGames(
        magazineNumber: Int
    ): List<GameDto> = HttpClientProvider
        .httpClient
        .get("/games/$magazineNumber")
        .body()

    suspend fun playGame(
        gameUrl: String
    ) {
        HttpClientProvider
            .httpClient
            .post(gameUrl)
    }
}
