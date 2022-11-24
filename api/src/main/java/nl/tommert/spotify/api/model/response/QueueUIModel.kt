package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.ItemUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class QueueUIModel(
    val currentlyPlaying: ItemUIModel,
    val queue: ItemUIModel,
) : SpotifyUIModel
