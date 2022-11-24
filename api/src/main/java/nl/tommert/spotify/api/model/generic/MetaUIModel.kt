package nl.tommert.spotify.api.model.generic

data class MetaUIModel(
    val analyzerVersion: String?,
    val platform: String?,
    val detailedStatus: String?,
    val statusCode: Int?,
    val timestamp: Int?,
    val analysisTime: Number?,
    val inputProcess: String?,
) : SpotifyUIModel
