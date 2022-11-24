package nl.tommert.spotify.api.model.generic

data class SegmentUIModel(
    val start: Number?,
    val duration: Number?,
    val confidence: Number?,
    val loudnessStart: Number?,
    val loudnessMax: Number?,
    val loudnessMaxTime: Number?,
    val loudnessEnd: Number?,
    val pitches: List<Number>?,
    val timbre: List<Number>?,
) : SpotifyUIModel
