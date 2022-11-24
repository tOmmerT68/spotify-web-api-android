package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class TracksUIModel(
    val tracks: List<TrackUIModel>,
) : SpotifyUIModel
