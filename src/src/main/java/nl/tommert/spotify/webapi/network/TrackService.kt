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

interface TrackService {

    /**
     * Get Spotify catalog information for a single track identified by its unique Spotify ID.
     * @param id The Spotify ID for the track.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("tracks/{id}")
    fun getTrack(
        @Path("id") id: String,
        @Query("market") market: String?,
    ): Track

    /**
     * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("tracks")
    fun getSeveralTracks(
        @Query("ids") ids: String,
        @Query("market") market: String?,
    ): Tracks

    /**
     * Get a list of the songs saved in the current Spotify user's 'Your Music' library.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("me/tracks")
    fun getUsersTracks(
        @Query("limit") limit: Int?,
        @Query("market") market: String?,
        @Query("offset") offset: Int?,
    ): Items<Track>

    /**
     * Save one or more tracks to the current user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @PUT("me/tracks")
    fun saveTracksForUser(
        @Query("ids") ids: String,
    )

    /**
     * Save one or more tracks to the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. For example: ["4iV5W9uYEdYUVa79Axb7Rh", "1301WleyT98MSxVHPZCA6M"]
     */
    @PUT("me/tracks")
    fun saveTracksForUser(
        @Body ids: Ids,
    )

    /**
     * Remove one or more tracks to the current user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @DELETE("me/tracks")
    fun removeTracksForUser(
        @Query("ids") ids: String,
    )

    /**
     * Remove one or more tracks to the current user's 'Your Music' library.
     * @param ids A JSON array of the Spotify IDs. For example: ["4iV5W9uYEdYUVa79Axb7Rh", "1301WleyT98MSxVHPZCA6M"]
     */
    @DELETE("me/tracks")
    fun removeTracksForUser(
        @Body ids: Ids,
    )

    /**
     * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     */
    @GET("me/tracks/contains")
    fun checkUserSavedTracks(
        @Query("ids") ids: String,
    ): Array<Boolean>

    /**
     * Get audio feature information for a single track identified by its unique Spotify ID.
     * @param id The Spotify ID for the track.
     */
    @GET("audio-features/{id}")
    fun getTracksAudioFeatures(
        @Path("id") id: String,
    ): AudioFeature

    /**
     * Get audio features for multiple tracks based on their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs for the tracks. Maximum: 100 IDs.
     */
    @GET("audio-features")
    fun getSeveralTracksAudioFeatures(
        @Query("ids") ids: String,
    )

    /**
     * Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s structure and musical content, including rhythm, pitch, and timbre.
     * @param id The Spotify ID for the track.
     */
    @GET("audio-analysis/{id}")
    fun getTracksAudioAnalysis(
        @Path("id") id: String,
    ): AudioAnalysis

    /**
     * Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.
     * If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.
     *
     * For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.
     */
    @GET("recommendations")
    fun getRecommendations(
        @Query("seed_artists") seedArtists: String,
        @Query("seed_genres") seedGenres: String,
        @Query("seed_tracks") seedTracks: String,
        @Query("limit") limit: Int?,
        @Query("market") market: String?,
        @Query("max_acousticness") maxAcousticness: Number?,
        @Query("max_danceability") maxDanceability: Number?,
        @Query("max_duration_ms") maxDurationMs: Int?,
        @Query("max_energy") maxEnergy: Number?,
        @Query("max_instrumentalness") maxInstrumentalness: Number?,
        @Query("max_key") maxKey: Int?,
        @Query("max_liveness") maxLiveness: Number?,
        @Query("max_loudness") maxLoudness: Number?,
        @Query("max_mode") maxMode: Int?,
        @Query("max_popularity") maxPopularity: Int?,
        @Query("max_speechiness") maxSpeechiness: Number?,
        @Query("max_tempo") maxTempo: Number?,
        @Query("max_time_signature") maxTimeSignature: Int?,
        @Query("max_valence") maxValence: Number?,
        @Query("min_acousticness") minAcousticness: Number?,
        @Query("min_danceability") minDanceability: Number?,
        @Query("min_duration_ms") minDurationMs: Int?,
        @Query("min_energy") minEnergy: Number?,
        @Query("min_instrumentalness") minInstrumentalness: Number?,
        @Query("min_key") minKey: Int?,
        @Query("min_liveness") minLiveness: Number?,
        @Query("min_loudness") minLoudness: Number?,
        @Query("min_mode") minMode: Int?,
        @Query("min_popularity") minPopularity: Int?,
        @Query("min_speechiness") minSpeechiness: Number?,
        @Query("min_tempo") minTempo: Number?,
        @Query("min_time_signature") minTimeSignature: Int?,
        @Query("min_valence") minValence: Number?,
        @Query("target_acousticness") targetAcousticness: Number?,
        @Query("target_danceability") targetDanceability: Number?,
        @Query("target_duration_ms") targetDurationMs: Int?,
        @Query("target_energy") targetEnergy: Number?,
        @Query("target_instrumentalness") targetInstrumentalness: Number?,
        @Query("target_key") targetKey: Int?,
        @Query("target_liveness") targetLiveness: Number?,
        @Query("target_loudness") targetLoudness: Number?,
        @Query("target_mode") targetMode: Int?,
        @Query("target_popularity") targetPopularity: Int?,
        @Query("target_speechiness") targetSpeechiness: Number?,
        @Query("target_tempo") targetTempo: Number?,
        @Query("target_time_signature") targetTimeSignature: Int?,
        @Query("target_valence") targetValence: Number?,
    ): Recommendation
}
