package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class ImageUIModel(
    val url: String,
    val height: Int,
    val width: Int,
) : SpotifyUIModel
