package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.response.Image
import nl.tommert.spotify.webapi.model.response.Items
import nl.tommert.spotify.webapi.model.response.Playlist
import nl.tommert.spotify.webapi.model.response.Track
import nl.tommert.spotify.webapi.model.request.AddTracksToPlaylistRequest
import nl.tommert.spotify.webapi.model.request.PlaylistRequest
import nl.tommert.spotify.webapi.model.request.RemovePlaylistItemsRequest
import nl.tommert.spotify.webapi.model.request.UpdatePlaylistItemsRequest
import nl.tommert.spotify.webapi.model.response.Snapshot
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PlaylistService : SpotifyService {

    /**
     * Get a playlist owned by a Spotify user.
     * @param id The Spotify ID of the playlist.
     * @param additionalTypes A comma-separated list of item types that your client supports besides the default track type. Valid types are: track and episode.
     * @param fields Filters for the query: a comma-separated list of the fields to return. If omitted, all fields are returned. For example, to get just the playlist''s description and URI: fields=description,uri. A dot separator can be used to specify non-reoccurring fields, while parentheses can be used to specify reoccurring fields within objects. For example, to get just the added date and user ID of the adder: fields=tracks.items(added_at,added_by.id). Use multiple parentheses to drill down into nested objects, for example: fields=tracks.items(track(name,href,album(name,href))). Fields can be excluded by prefixing them with an exclamation mark, for example: fields=tracks.items(track(name,href,album(!name,href)))
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("$PLAYLISTS/{id}")
    suspend fun getPlaylist(
        @Path("id") id: String,
        @Query("additional_types") additionalTypes: String? = null,
        @Query("fields") fields: String? = null,
        @Query("market") market: String? = null,
    ): Playlist

    /**
     * Change a playlist's name and public/private state. (The user must, of course, own the playlist.)
     * @param id The Spotify ID of the playlist.
     * @param request The request with all body parameters.
     */
    @PUT("$PLAYLISTS/{id}")
    suspend fun changePlaylistDetails(
        @Path("id") id: String,
        @Body request: PlaylistRequest,
    )

    /**
     * Get full details of the items of a playlist owned by a Spotify user.
     * @param id The Spotify ID of the playlist.
     * @param additionalTypes A comma-separated list of item types that your client supports besides the default track type. Valid types are: track and episode.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("$PLAYLISTS/{id}/tracks")
    suspend fun getPlaylistItems(
        @Path("id") id: String,
        @Query("additional_types") additionalTypes: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Track>

    /**
     * Add one or more items to a user's playlist.
     * @param id The Spotify ID of the playlist.
     * @param position The position to insert the items, a zero-based index. For example, to insert the items in the first position: position=0; to insert the items in the third position: position=2.
     * If omitted, the items will be appended to the playlist. Items are added in the order they are listed in the query string or request body.
     * @param uris A comma-separated list of Spotify URIs to add, can be track or episode URIs.
     * For example: uris=spotify:track:4iV5W9uYEdYUVa79Axb7Rh,spotify:track:1301WleyT98MSxVHPZCA6M,spotify:episode:512ojhOuo1ktJprKbVcKyQ
     * A maximum of 100 items can be added in one request.
     */
    @POST("$PLAYLISTS/{id}/tracks")
    suspend fun addTracksToPlaylist(
        @Path("id") id: String,
        @Query("position") position: Int? = null,
        @Query("uris") uris: String? = null,
    ): Snapshot

    /**
     * Add one or more items to a user's playlist.
     * @param id The Spotify ID of the playlist.
     * @param request The request with all body parameters.
     */
    @POST("$PLAYLISTS/{id}/tracks")
    suspend fun addTracksToPlaylist(
        @Path("id") id: String,
        @Body request: AddTracksToPlaylistRequest,
    ): Snapshot

    /**
     * Either reorder or replace items in a playlist depending on the request's parameters.
     * To reorder items, include range_start, insert_before, range_length and snapshot_id in the request's body.
     * To replace items, include uris as either a query parameter or in the request's body. Replacing items in a playlist will overwrite its existing items.
     * This operation can be used for replacing or clearing items in a playlist.
     * @param id The Spotify ID of the playlist.
     * @param request The request with all body parameters.
     */
    @PUT("$PLAYLISTS/{id}/tracks")
    suspend fun updatePlaylistItems(
        @Path("id") id: String,
        @Body request: UpdatePlaylistItemsRequest,
    ): Snapshot

    /**
     * Remove one or more items from a user's playlist.
     * @param id The Spotify ID of the playlist.
     * @param request The request with all body parameters.
     */
    @DELETE("$PLAYLISTS/{id}/tracks")
    suspend fun removePlaylistItems(
        @Path("id") id: String,
        @Body request: RemovePlaylistItemsRequest,
    ): Snapshot

    /**
     * Get a list of the playlists owned or followed by the current Spotify user.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("me/$PLAYLISTS")
    suspend fun getCurrentUsersPlaylists(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Playlist>

    /**
     * Get a list of the playlists owned or followed by a Spotify user.
     * @param id The user's Spotify user ID.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param offset The index of the first playlist to return. Default: 0 (the first object). Maximum offset: 100.000. Use with limit to get the next set of playlists.
     */
    @GET("users/{id}/$PLAYLISTS")
    suspend fun getUsersPlaylist(
        @Path("id") id: String,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Playlist>

    /**
     * Create a playlist for a Spotify user. (The playlist will be empty until you add tracks.)
     * @param id The user's Spotify user ID.
     * @param request The request with all body parameters.
     */
    @POST("users/{id}/$PLAYLISTS")
    suspend fun createPlaylist(
        @Path("id") id: String,
        @Body request: PlaylistRequest,
    ): Playlist

    /**
     * Get a list of Spotify featured playlists (shown, for example, on a Spotify player's 'Browse' tab).
     * @param country A country: an ISO 3166-1 alpha-2 country code. Provide this parameter if you want the list of returned items to be relevant to a particular country.
     * If omitted, the returned items will be relevant to all countries.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param locale The desired language, consisting of a lowercase ISO 639-1 language code and an uppercase ISO 3166-1 alpha-2 country code, joined by an underscore. For example: es_MX, meaning "Spanish (Mexico)".
     * Provide this parameter if you want the results returned in a particular language (where available).
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     * @param timestamp A timestamp in ISO 8601 format: yyyy-MM-ddTHH:mm:ss. Use this parameter to specify the user's local time to get results tailored for that specific date and time in the day.
     * If not provided, the response defaults to the current UTC time.
     */
    @GET("browse/featured-$PLAYLISTS")
    suspend fun getFeaturedPlaylists(
        @Query("country") country: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("locale") locale: String? = null,
        @Query("offset") offset: Int? = null,
        @Query("timestamp") timestamp: String? = null,
    )

    /**
     * Get a list of Spotify playlists tagged with a particular category.
     * @param id The Spotify category ID for the category.
     * @param country A country: an ISO 3166-1 alpha-2 country code. Provide this parameter to ensure that the category exists for a particular country.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("browse/categories/{id}/$PLAYLISTS")
    suspend fun getCategoryPlaylists(
        @Path("id") id: String,
        @Query("country") country: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Playlist>

    /**
     * Get the current image associated with a specific playlist.
     * @param id The Spotify ID of the playlist.
     */
    @GET("$PLAYLISTS/{id}/images")
    suspend fun getPlaylistCoverImage(
        @Path("id") id: String,
    ): Array<Image>

    companion object {

        const val PLAYLISTS = "playlists"
    }
}
