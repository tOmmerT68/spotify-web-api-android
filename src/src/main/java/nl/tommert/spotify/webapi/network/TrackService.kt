package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Items
import nl.tommert.spotify.webapi.model.generic.Ids
import nl.tommert.spotify.webapi.model.response.AudioAnalysis
import nl.tommert.spotify.webapi.model.response.AudioFeature
import nl.tommert.spotify.webapi.model.response.Recommendation
import nl.tommert.spotify.webapi.model.response.Track
import nl.tommert.spotify.webapi.model.response.Tracks
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TrackService : SpotifyService {

    /**
     * Get Spotify catalog information for a single track identified by its unique Spotify ID.
     * @param id The Spotify ID for the track.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("tracks/{id}")
    suspend fun getTrack(
        @Path("id") id: String,
        @Query("market") market: String? = null,
    ): Track

    /**
     * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("tracks")
    suspend fun getSeveralTracks(
        @Query("ids") ids: String,
        @Query("market") market: String? = null,
    ): Tracks

    /**
     * Get a list of the songs saved in the current Spotify user's 'Your Music' library.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("me/tracks")
    suspend fun getUsersTracks(
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Track>

    /**
     * Save one or more tracks to the current user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @PUT("me/tracks")
    suspend fun saveTracksForUser(
        @Query("ids") ids: String,
    )

    /**
     * Save one or more tracks to the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. For example: ["4iV5W9uYEdYUVa79Axb7Rh", "1301WleyT98MSxVHPZCA6M"]
     */
    @PUT("me/tracks")
    suspend fun saveTracksForUser(
        @Body ids: Ids,
    )

    /**
     * Remove one or more tracks to the current user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @DELETE("me/tracks")
    suspend fun removeTracksForUser(
        @Query("ids") ids: String,
    )

    /**
     * Remove one or more tracks to the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. For example: ["4iV5W9uYEdYUVa79Axb7Rh", "1301WleyT98MSxVHPZCA6M"]
     */
    @DELETE("me/tracks")
    suspend fun removeTracksForUser(
        @Body ids: Ids,
    )

    /**
     * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @GET("me/tracks/contains")
    suspend fun checkUserSavedTracks(
        @Query("ids") ids: String,
    ): Array<Boolean>

    /**
     * Get audio feature information for a single track identified by its unique Spotify ID.
     * @param id The Spotify ID for the track.
     */
    @GET("audio-features/{id}")
    suspend fun getTracksAudioFeatures(
        @Path("id") id: String,
    ): AudioFeature

    /**
     * Get audio features for multiple tracks based on their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs for the tracks. Maximum: 100 IDs.
     */
    @GET("audio-features")
    suspend fun getSeveralTracksAudioFeatures(
        @Query("ids") ids: String,
    )

    /**
     * Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s structure and musical content, including rhythm, pitch, and timbre.
     * @param id The Spotify ID for the track.
     */
    @GET("audio-analysis/{id}")
    suspend fun getTracksAudioAnalysis(
        @Path("id") id: String,
    ): AudioAnalysis

    /**
     * Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.
     * If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.
     *
     * For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.
     */
    @GET("recommendations")
    suspend fun getRecommendations(
        @Query("seed_artists") seedArtists: String,
        @Query("seed_genres") seedGenres: String,
        @Query("seed_tracks") seedTracks: String,
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("max_acousticness") maxAcousticness: Number? = null,
        @Query("max_danceability") maxDanceability: Number? = null,
        @Query("max_duration_ms") maxDurationMs: Int? = null,
        @Query("max_energy") maxEnergy: Number? = null,
        @Query("max_instrumentalness") maxInstrumentalness: Number? = null,
        @Query("max_key") maxKey: Int? = null,
        @Query("max_liveness") maxLiveness: Number? = null,
        @Query("max_loudness") maxLoudness: Number? = null,
        @Query("max_mode") maxMode: Int? = null,
        @Query("max_popularity") maxPopularity: Int? = null,
        @Query("max_speechiness") maxSpeechiness: Number? = null,
        @Query("max_tempo") maxTempo: Number? = null,
        @Query("max_time_signature") maxTimeSignature: Int? = null,
        @Query("max_valence") maxValence: Number? = null,
        @Query("min_acousticness") minAcousticness: Number? = null,
        @Query("min_danceability") minDanceability: Number? = null,
        @Query("min_duration_ms") minDurationMs: Int? = null,
        @Query("min_energy") minEnergy: Number? = null,
        @Query("min_instrumentalness") minInstrumentalness: Number? = null,
        @Query("min_key") minKey: Int? = null,
        @Query("min_liveness") minLiveness: Number? = null,
        @Query("min_loudness") minLoudness: Number? = null,
        @Query("min_mode") minMode: Int? = null,
        @Query("min_popularity") minPopularity: Int? = null,
        @Query("min_speechiness") minSpeechiness: Number? = null,
        @Query("min_tempo") minTempo: Number? = null,
        @Query("min_time_signature") minTimeSignature: Int? = null,
        @Query("min_valence") minValence: Number? = null,
        @Query("target_acousticness") targetAcousticness: Number? = null,
        @Query("target_danceability") targetDanceability: Number? = null,
        @Query("target_duration_ms") targetDurationMs: Int? = null,
        @Query("target_energy") targetEnergy: Number? = null,
        @Query("target_instrumentalness") targetInstrumentalness: Number? = null,
        @Query("target_key") targetKey: Int? = null,
        @Query("target_liveness") targetLiveness: Number? = null,
        @Query("target_loudness") targetLoudness: Number? = null,
        @Query("target_mode") targetMode: Int? = null,
        @Query("target_popularity") targetPopularity: Int? = null,
        @Query("target_speechiness") targetSpeechiness: Number? = null,
        @Query("target_tempo") targetTempo: Number? = null,
        @Query("target_time_signature") targetTimeSignature: Int? = null,
        @Query("target_valence") targetValence: Number? = null,
    ): Recommendation
}
