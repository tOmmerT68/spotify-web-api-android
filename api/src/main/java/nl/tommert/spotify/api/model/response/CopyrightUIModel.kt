package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class CopyrightUIModel(
    val text: String?,
    val type: String?,
) : SpotifyUIModel
