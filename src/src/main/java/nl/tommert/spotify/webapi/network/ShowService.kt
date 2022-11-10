package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Episode
import nl.tommert.spotify.webapi.model.Items
import nl.tommert.spotify.webapi.model.generic.Ids
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ShowService {

    /**
     * Get Spotify catalog information for a single episode identified by its unique Spotify ID.
     * @param id The Spotify ID for the episode.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("$EPISODES/{id}")
    suspend fun getEpisode(
        @Path("id") id: String,
        @Query("market") market: String? = null,
    ): Episode

    /**
     * Get Spotify catalog information for several episodes based on their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs for the episodes. Maximum: 50 IDs.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET(EPISODES)
    suspend fun getSeveralEpisodes(
        @Query("ids") ids: String,
        @Query("market") market: String? = null,
    ): Array<Episode>

    /**
     * Get a list of the episodes saved in the current Spotify user's library.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("me/episodes")
    suspend fun getUserSavedEpisodes(
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Episode>

    /**
     * Save one or more episodes to the current user's library.
     * @param ids A comma-separated list of the Spotify IDs. Maximum: 50 IDs.
     */
    @PUT("me/$EPISODES")
    suspend fun putUserSavedEpisode(
        @Query("ids") ids: String,
    )

    /**
     * Save one or more episodes to the current user's library.
     * @param ids A JSON array of the Spotify IDs.
     */
    @PUT("me/$EPISODES")
    suspend fun putUserSavedEpisode(
        @Body ids: Ids,
    )

    /**
     * Remove one or more episodes from the current user's library.
     * @param ids A comma-separated list of the Spotify IDs. Maximum: 50 IDs.
     */
    @DELETE("me/$EPISODES")
    suspend fun deleteUserSavedEpisode(
        @Query("ids") ids: String,
    )

    /**
     * Remove one or more episodes from the current user's library.
     * @param ids A JSON array of the Spotify IDs.
     */
    @DELETE("me/$EPISODES")
    suspend fun deleteUserSavedEpisode(
        @Body ids: Ids,
    )

    /**
     * Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.
     * @param ids A comma-separated list of the Spotify IDs. Maximum: 50 IDs.
     */
    @GET("me/$EPISODES/contains")
    suspend fun getUserSavedEpisodesContains(
        @Query("ids") ids: String,
    )

    companion object {

        const val EPISODES = "episodes"
    }
}
