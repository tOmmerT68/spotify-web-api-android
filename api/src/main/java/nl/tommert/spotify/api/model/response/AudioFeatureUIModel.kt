package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class AudioFeatureUIModel(
    val acousticness: Float?,
    val analysisUrl: String?,
    val danceability: Float?,
    val durationMs: Int?,
    val energy: Float?,
    val id: String?,
    val instrumentalness: Float?,
    val key: Int?,
    val liveness: Float?,
    val loudness: Float?,
    val mode: Int?,
    val speechiness: Float?,
    val tempo: Float?,
    val timeSignature: Int?,
    val trackHref: String?,
    val type: String?,
    val uri: String?,
    val valence: Float?,
) : SpotifyUIModel
