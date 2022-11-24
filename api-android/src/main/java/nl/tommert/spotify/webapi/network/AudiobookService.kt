package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.response.Audiobook
import nl.tommert.spotify.webapi.model.response.Chapter
import nl.tommert.spotify.webapi.model.response.Items
import nl.tommert.spotify.webapi.model.response.Audiobooks
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface AudiobookService : SpotifyService {

    /**
     * Get Spotify catalog information for a single audiobook.
     * @param id The Spotify ID for the audiobook.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("$AUDIOBOOKS/{id}")
    suspend fun getAudiobook(
        @Path("id") id: String,
        @Query("market") market: String? = null,
    ): Audiobook

    /**
     * Get Spotify catalog information for several audiobooks identified by their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET(AUDIOBOOKS)
    suspend fun getSeveralAudiobooks(
        @Query("ids") ids: String,
        @Query("market") market: String? = null,
    ): Audiobooks

    /**
     * Get Spotify catalog information about an audiobook's chapters.
     * @param id The Spotify ID for the audiobook.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("$AUDIOBOOKS/{id}/chapters")
    suspend fun getAudiobookChapters(
        @Path("id") id: String,
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Chapter>

    /**
     * Get a list of the audiobooks saved in the current Spotify user's 'Your Music' library.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("me/$AUDIOBOOKS")
    suspend fun getUsersSavedAudiobooks(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Audiobook>

    /**
     * Save one or more audiobooks to the current Spotify user's library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @PUT("me/$AUDIOBOOKS")
    suspend fun saveAudiobooks(
        @Query("ids") ids: String,
    )

    /**
     * Remove one or more audiobooks from the Spotify user's library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @DELETE("me/$AUDIOBOOKS")
    suspend fun removeAudiobooks(
        @Query("ids") ids: String,
    )

    /**
     * Check if one or more audiobooks are already saved in the current Spotify user's library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @GET("me/$AUDIOBOOKS/contains")
    suspend fun checkUsersSavedAudiobooks(
        @Query("ids") ids: String,
    ): Array<Boolean>

    companion object {

        const val AUDIOBOOKS = "audiobooks"
    }
}
