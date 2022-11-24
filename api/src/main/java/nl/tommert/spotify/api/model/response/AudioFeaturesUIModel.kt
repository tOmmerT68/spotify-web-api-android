package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class AudioFeaturesUIModel(
    val audioFeatures: List<AudioFeatureUIModel>,
) : SpotifyUIModel
