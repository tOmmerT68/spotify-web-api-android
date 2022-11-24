package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class SearchResultUIModel(
    val tracks: ItemsUIModel<SpotifyUIModel>?,
    val artists: ItemsUIModel<SpotifyUIModel>?,
    val albums: ItemsUIModel<SpotifyUIModel>?,
    val playlists: ItemsUIModel<SpotifyUIModel>?,
    val shows: ItemsUIModel<SpotifyUIModel>?,
    val episodes: ItemsUIModel<SpotifyUIModel>?,
    val audiobooks: ItemsUIModel<SpotifyUIModel>?,
) : SpotifyUIModel
