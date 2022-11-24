package nl.tommert.spotify.api.model.generic

data class SeedUIModel(
    val afterFilteringSize: Int?,
    val afterRelinkingSize: Int?,
    val href: String?,
    val id: String?,
    val initialPoolSize: Int?,
    val type: String?,
) : SpotifyUIModel
