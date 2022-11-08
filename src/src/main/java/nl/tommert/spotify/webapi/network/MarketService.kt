package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Markets
import retrofit2.http.GET

interface MarketService {

    /**
     * Get the list of markets where Spotify is available.
     */
    @GET("markets")
    fun getAvailableMarkets(): Markets
}
