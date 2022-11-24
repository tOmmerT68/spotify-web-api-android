package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SeedUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class RecommendationUIModel(
    val seeds: List<SeedUIModel>,
    val tracks: List<TrackUIModel>,
) : SpotifyUIModel
