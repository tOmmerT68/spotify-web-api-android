package nl.tommert.spotify.api.model.generic

data class BarUIModel(
    val start: Number?,
    val duration: Number?,
    val confidence: Number?,
) : SpotifyUIModel
