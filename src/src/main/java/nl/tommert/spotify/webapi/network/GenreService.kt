package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Genres
import retrofit2.http.GET

interface GenreService {

    /**
     * Retrieve a list of available genres seed parameter values for recommendations.
     */
    @GET("recommendations/available-genre-seeds")
    suspend fun getAvailableGenreSeeds(): Genres
}
