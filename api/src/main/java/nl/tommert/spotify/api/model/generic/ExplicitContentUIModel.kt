package nl.tommert.spotify.api.model.generic

data class ExplicitContentUIModel(
    val filterEnabled: Boolean,
    val filterLocked: Boolean,
) : SpotifyUIModel
