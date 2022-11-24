package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class ResumePointUIModel(
    val fullyPlayed: Boolean,
    val resumePositionMs: Int,
) : SpotifyUIModel
