package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class RestrictionUIModel(
    val reason: String?,
) : SpotifyUIModel
