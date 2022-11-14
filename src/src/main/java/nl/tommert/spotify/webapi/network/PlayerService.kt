package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Items
import nl.tommert.spotify.webapi.model.response.Track
import nl.tommert.spotify.webapi.model.generic.Device
import nl.tommert.spotify.webapi.model.request.PlayRequest
import nl.tommert.spotify.webapi.model.request.PlaybackRequest
import nl.tommert.spotify.webapi.model.response.Playback
import nl.tommert.spotify.webapi.model.response.Queue
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface PlayerService : SpotifyService {

    /**
     * Get information about the user’s current playback state, including track or episode, progress, and active device.
     * @param additionalTypes A comma-separated list of item types that your client supports besides the default track type. Valid types are: track and episode.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("me/player")
    suspend fun getPlaybackState(
        @Query("additional_types") additionalTypes: String? = null,
        @Query("market") market: String? = null,
    ): Playback

    /**
     * Transfer playback to a new device and determine if it should start playing.
     * @param request The request with all body parameters.
     */
    @PUT("me/player")
    suspend fun transferPlayback(
        @Body request: PlaybackRequest,
    )

    /**
     * Get information about a user’s available devices.
     */
    @GET("me/player/devices")
    suspend fun getAvailableDevices(): Array<Device>

    /**
     * Get the object currently being played on the user's Spotify account.
     * @param additionalTypes A comma-separated list of item types that your client supports besides the default track type. Valid types are: track and episode.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("me/player/currently-playing")
    suspend fun getCurrentlyPlayingTrack(
        @Query("additional_types") additionalTypes: String? = null,
        @Query("market") market: String? = null,
    ): Playback

    /**
     * Start a new context or resume current playback on the user's active device.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     * @param request The request with all body parameters.
     */
    @PUT("me/player/play")
    suspend fun startPlayback(
        @Query("device_id") deviceId: String? = null,
        @Body request: PlayRequest? = null,
    )

    /**
     * Pause playback on the user's account.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @PUT("me/player/pause")
    suspend fun pausePlayback(
        @Query("device_id") deviceId: String? = null,
    )

    /**
     * Skips to next track in the user’s queue.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @POST("me/player/next")
    suspend fun skipToNext(
        @Query("device_id") deviceId: String? = null,
    )

    /**
     * Skips to previous track in the user’s queue.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @POST("me/player/previous")
    suspend fun skipToPrevious(
        @Query("device_id") deviceId: String? = null,
    )

    /**
     * Seeks to the given position in the user’s currently playing track.
     * @param positionMs The position in milliseconds to seek to. Must be a positive number. Passing in a position that is greater than the length of the track will cause the player to start playing the next song.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @PUT("me/player/seek")
    suspend fun seekToPosition(
        @Query("position_ms") positionMs: Int,
        @Query("device_id") deviceId: String? = null,
    )

    /**
     * Set the repeat mode for the user's playback. Options are repeat-track, repeat-context, and off.
     * @param state track, context or off.
     * track will repeat the current track.
     * context will repeat the current context.
     * off will turn repeat off.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @PUT("me/player/repeat")
    suspend fun setRepeatMode(
        @Query("state") state: String,
        @Query("device_id") deviceId: String? = null,
    )

    /**
     * Set the volume for the user’s current playback device.
     * @param volumePercent The volume to set. Must be a value from 0 to 100 inclusive.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @PUT("me/player/volume")
    suspend fun setPlayerVolume(
        @Query("volume_percent") volumePercent: Int,
        @Query("device_id") deviceId: String? = null,
    )

    /**
     * Get tracks from the current user's recently played tracks.
     * @param after A Unix timestamp in milliseconds. Returns all items after (but not including) this cursor position. If after is specified, before must not be specified.
     * @param before A Unix timestamp in milliseconds. Returns all items before (but not including) this cursor position. If before is specified, after must not be specified.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @GET("me/player/recently-played")
    suspend fun getRecentlyPlayedTracks(
        @Query("after") after: Int? = null,
        @Query("before") before: Int? = null,
        @Query("limit") limit: Int? = null,
    ): Items<Track>

    /**
     * Get the list of objects that make up the user's queue.
     */
    @GET("me/player/queue")
    suspend fun getUsersQueue(): Queue

    /**
     * Add an item to the end of the user's current playback queue.
     * @param uri The uri of the item to add to the queue. Must be a track or an episode uri.
     * @param deviceId The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @POST("me/player/queue")
    suspend fun addItemToPlaybackQueue(
        @Query("uri") uri: String,
        @Query("device_id") deviceId: String? = null,
    )
}
