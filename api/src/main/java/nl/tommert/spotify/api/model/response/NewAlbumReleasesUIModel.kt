package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class NewAlbumReleasesUIModel(
    val albums: ItemsUIModel<SpotifyUIModel>,
) : SpotifyUIModel
