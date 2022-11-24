package nl.tommert.spotify.api.model.generic

data class ExternalIdsUIModel(
    val isrc: String?,
    val ean: String?,
    val upc: String?,
) : SpotifyUIModel
