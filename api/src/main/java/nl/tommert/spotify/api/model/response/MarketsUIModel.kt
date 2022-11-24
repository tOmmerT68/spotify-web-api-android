package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class MarketsUIModel(
    val markets: List<String>,
) : SpotifyUIModel
