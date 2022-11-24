package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class AudiobooksUIModel(
    val audiobooks: List<AudiobookUIModel>,
) : SpotifyUIModel
