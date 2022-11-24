package nl.tommert.spotify.api.model.generic

data class FollowersUIModel(
    val href: String,
    val total: Int,
) : SpotifyUIModel
