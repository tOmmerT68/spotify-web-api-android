package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.ExplicitContentUIModel
import nl.tommert.spotify.api.model.generic.FollowersUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class UserUIModel(
    val country: String,
    val displayName: String?,
    val email: String,
    val explicitContent: ExplicitContentUIModel,
    val externalUrls: SpotifyUrlUIModel,
    val followers: FollowersUIModel,
    val href: String,
    val id: String,
    val images: List<ImageUIModel>,
    val product: String,
    val type: String,
    val uri: String,
) : SpotifyUIModel
