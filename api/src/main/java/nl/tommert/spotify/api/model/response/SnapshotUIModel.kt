package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class SnapshotUIModel(
    val snapshotId: String,
) : SpotifyUIModel
