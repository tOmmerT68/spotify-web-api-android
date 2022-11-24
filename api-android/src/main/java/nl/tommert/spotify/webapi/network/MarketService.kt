package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.response.Markets
import retrofit2.http.GET

interface MarketService : SpotifyService {

    /**
     * Get the list of markets where Spotify is available.
     */
    @GET("markets")
    suspend fun getAvailableMarkets(): Markets
}
