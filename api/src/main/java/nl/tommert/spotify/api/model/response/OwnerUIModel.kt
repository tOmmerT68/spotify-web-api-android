package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.FollowersUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class OwnerUIModel(
    val externalUrls: SpotifyUrlUIModel?,
    val followers: FollowersUIModel?,
    val href: String?,
    val id: String?,
    val type: String?,
    val uri: String?,
) : SpotifyUIModel
