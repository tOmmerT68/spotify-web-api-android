package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class ArtistsUIModel(
    val artists: ItemsUIModel<SpotifyUIModel>,
) : SpotifyUIModel
