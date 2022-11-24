package nl.tommert.spotify.api.model.generic

data class PlayerContextUIModel(
    val type: String?,
    val href: String?,
    val externalUrls: SpotifyUrlUIModel,
    val uri: String,
) : SpotifyUIModel
