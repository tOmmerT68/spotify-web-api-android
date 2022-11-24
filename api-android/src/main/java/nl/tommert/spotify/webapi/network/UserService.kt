package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.response.Items
import nl.tommert.spotify.webapi.model.generic.Ids
import nl.tommert.spotify.webapi.model.generic.Public
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
import nl.tommert.spotify.webapi.model.response.Artists
import nl.tommert.spotify.webapi.model.response.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService : SpotifyService {

    /**
     * Get detailed profile information about the current user (including the current user's username).
     */
    @GET("me")
    suspend fun getCurrentUsersProfile(): User

    /**
     * Get the current user's top artists or tracks based on calculated affinity.
     * @param type The type of entity to return. Valid values: artists or tracks
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     * @param time_range Over what time frame the affinities are computed. Valid values: long_term (calculated from several years of data and including all new data as it becomes available),
     * medium_term (approximately last 6 months), short_term (approximately last 4 weeks). Default: medium_term
     */
    @GET("me/top/{type}")
    suspend fun getUsersTopItems(
        @Path("type") type: String,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
        @Query("time_range") time_range: Int? = null,
    ): Items<SpotifyModel>

    /**
     * Get public profile information about a Spotify user.
     * @param id The user's Spotify user ID.
     */
    @GET("users/{id}")
    suspend fun getUsersProfile(
        @Path("id") id: String,
    ): User

    /**
     * Add the current user as a follower of a playlist.
     * @param id The Spotify ID of the playlist.
     * @param request The request with all body parameters.
     */
    @POST("playlists/{id}/followers")
    suspend fun followPlaylist(
        @Path("id") id: String,
        @Body request: Public? = null,
    )

    /**
     * Remove the current user as a follower of a playlist.
     * @param id The Spotify ID of the playlist.
     */
    @DELETE("playlists/{id}/followers")
    suspend fun unfollowPlaylist(
        @Path("id") id: String,
    )

    /**
     * Get the current user's followed artists.
     * @param type The ID type: currently only artist is supported.
     * @param after The last artist ID retrieved from the previous request.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @GET("me/following")
    suspend fun getFollowedArtists(
        @Query("type") type: String,
        @Query("after") after: String? = null,
        @Query("limit") limit: Int? = null,
    ): Artists

    /**
     * Add the current user as a follower of one or more artists or other Spotify users.
     * @param ids A comma-separated list of the artist or the user Spotify IDs. For example: ids=74ASZWbe4lXaubB36ztrGX,08td7MxkoHQkXnWAYD8d6Q.
     * A maximum of 50 IDs can be sent in one request.
     * @param type The ID type: either artist or user.
     */
    @PUT("me/following")
    suspend fun followArtistsOrUsers(
        @Query("ids") ids: String,
        @Query("type") type: String,
    )

    /**
     * Add the current user as a follower of one or more artists or other Spotify users.
     * @param request A JSON array of the artist or user Spotify IDs. For example: {ids:["74ASZWbe4lXaubB36ztrGX", "08td7MxkoHQkXnWAYD8d6Q"]}.
     * A maximum of 50 IDs can be sent in one request.
     * @param type The ID type: either artist or user.
     */
    @PUT("me/following")
    suspend fun followArtistsOrUsers(
        @Body request: Ids,
        @Query("type") type: String,
    )

    /**
     * Remove the current user as a follower of one or more artists or other Spotify users.
     * @param ids A comma-separated list of the artist or the user Spotify IDs. For example: ids=74ASZWbe4lXaubB36ztrGX,08td7MxkoHQkXnWAYD8d6Q.
     * A maximum of 50 IDs can be sent in one request.
     * @param type The ID type: either artist or user.
     */
    @DELETE("me/following")
    suspend fun unfollowArtistsOrUsers(
        @Query("ids") ids: String,
        @Query("type") type: String,
    )

    /**
     * Remove the current user as a follower of one or more artists or other Spotify users.
     * @param request A JSON array of the artist or user Spotify IDs. For example: {ids:["74ASZWbe4lXaubB36ztrGX", "08td7MxkoHQkXnWAYD8d6Q"]}.
     * A maximum of 50 IDs can be sent in one request.
     * @param type The ID type: either artist or user.
     */
    @DELETE("me/following")
    suspend fun unfollowArtistsOrUsers(
        @Body request: Ids,
        @Query("type") type: String,
    )

    /**
     * Check to see if the current user is following one or more artists or other Spotify users.
     * @param ids A comma-separated list of the artist or the user Spotify IDs to check. For example: ids=74ASZWbe4lXaubB36ztrGX,08td7MxkoHQkXnWAYD8d6Q.
     * A maximum of 50 IDs can be sent in one request.
     * @param type The ID type: either artist or user.
     */
    @GET("me/following/contains")
    suspend fun checkIfUserFollowsArtistsOrUsers(
        @Query("ids") ids: String,
        @Query("type") type: String,
    ): Array<Boolean>

    /**
     * Check to see if one or more Spotify users are following a specified playlist.
     * @param id The Spotify ID of the playlist.
     * @param ids A comma-separated list of Spotify User IDs ; the ids of the users that you want to check to see if they follow the playlist. Maximum: 5 ids.
     */
    @GET("playlists/{id}/followers/contains")
    suspend fun checkIfUsersFollowPlaylist(
        @Path("id") id: String,
        @Query("ids") ids: String,
    )
}
