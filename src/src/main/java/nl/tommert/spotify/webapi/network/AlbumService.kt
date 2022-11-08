package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Album
import nl.tommert.spotify.webapi.model.NewAlbumReleases
import nl.tommert.spotify.webapi.model.Items
import nl.tommert.spotify.webapi.model.Track
import nl.tommert.spotify.webapi.model.generic.Ids
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {

    /**
     * Get Spotify catalog information for a single album.
     * @param albumId The Spotify ID of the album.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("$ALBUMS/{id}")
    fun getAlbum(
        @Path("id") albumId: String,
        @Query("market") market: String?,
    ): Album

    /**
     * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET(ALBUMS)
    fun getAlbums(
        @Query("ids") ids: String,
        @Query("market") market: String?,
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
    fun getAlbumTracks(
        @Path("id") albumId: String,
        @Query("limit") limit: Int?,
        @Query("market") market: String?,
        @Query("offset") offset: Int?,
    ): Items<Track>

    /**
     * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("me/$ALBUMS")
    fun getUserSavedAlbums(
        @Query("limit") limit: Int?,
        @Query("market") market: String?,
        @Query("offset") offset: Int?,
    ): Items<Album>

    /**
     * Save one or more albums to the current user's 'Your Music' library.
     * A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @PUT("me/$ALBUMS")
    fun putUserSavedAlbums(
        @Query("ids") ids: String,
    )

    /**
     * Save one or more albums to the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. A maximum of 50 items can be specified in one request.
     */
    @PUT("me/$ALBUMS")
    fun putUserSavedAlbums(
        @Body ids: Ids,
    )

    /**
     * Remove one or more albums from the current user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @DELETE("me/$ALBUMS")
    fun deleteUserSavedAlbums(
        @Query("ids") ids: String,
    )

    /**
     * Remove one or more albums from the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. A maximum of 50 items can be specified in one request.
     */
    @DELETE("me/$ALBUMS")
    fun deleteUserSavedAlbums(
        @Body ids: Ids,
    )

    /**
     * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @GET("me/$ALBUMS/contains")
    fun getUserSavedAlbumsContains(
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
    fun getNewReleases(
        @Query("country") country: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?,
    ): NewAlbumReleases

    companion object {

        const val ALBUMS = "albums"
    }
}
