package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.response.Album
import nl.tommert.spotify.webapi.model.response.NewAlbumReleases
import nl.tommert.spotify.webapi.model.response.Items
import nl.tommert.spotify.webapi.model.response.Track
import nl.tommert.spotify.webapi.model.generic.Ids
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService : SpotifyService {

    /**
     * Get Spotify catalog information for a single album.
     * @param albumId The Spotify ID of the album.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("$ALBUMS/{id}")
    suspend fun getAlbum(
        @Path("id") albumId: String,
        @Query("market") market: String? = null,
    ): Album

    /**
     * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET(ALBUMS)
    suspend fun getAlbums(
        @Query("ids") ids: String,
        @Query("market") market: String? = null,
    ): Array<Album>

    /**
     * Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of tracks returned.
     * @param albumId The Spotify ID of the album.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("$ALBUMS/{id}/tracks")
    suspend fun getAlbumTracks(
        @Path("id") albumId: String,
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Track>

    /**
     * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("me/$ALBUMS")
    suspend fun getUserSavedAlbums(
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Album>

    /**
     * Save one or more albums to the current user's 'Your Music' library.
     * A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @PUT("me/$ALBUMS")
    suspend fun putUserSavedAlbums(
        @Query("ids") ids: String,
    )

    /**
     * Save one or more albums to the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. A maximum of 50 items can be specified in one request.
     */
    @PUT("me/$ALBUMS")
    suspend fun putUserSavedAlbums(
        @Body ids: Ids,
    )

    /**
     * Remove one or more albums from the current user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @DELETE("me/$ALBUMS")
    suspend fun deleteUserSavedAlbums(
        @Query("ids") ids: String,
    )

    /**
     * Remove one or more albums from the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. A maximum of 50 items can be specified in one request.
     */
    @DELETE("me/$ALBUMS")
    suspend fun deleteUserSavedAlbums(
        @Body ids: Ids,
    )

    /**
     * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @GET("me/$ALBUMS/contains")
    suspend fun getUserSavedAlbumsContains(
        @Query("ids") ids: String,
    ): Array<Boolean>

    /**
     * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).
     * @param country A country: an ISO 3166-1 alpha-2 country code. Provide this parameter if you want the list of returned items to be relevant to a particular country.
     * If omitted, the returned items will be relevant to all countries.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("browse/new-releases")
    suspend fun getNewReleases(
        @Query("country") country: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): NewAlbumReleases

    companion object {

        const val ALBUMS = "albums"
    }
}
