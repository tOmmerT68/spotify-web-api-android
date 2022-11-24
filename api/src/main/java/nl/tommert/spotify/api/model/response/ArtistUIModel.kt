package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.FollowersUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class ArtistUIModel(
    val externalUrls: SpotifyUrlUIModel?,
    val followers: FollowersUIModel?,
    val genres: List<String>?,
    val href: String?,
    val id: String?,
    val images: List<ImageUIModel>?,
    val name: String?,
    val popularity: Int?,
    val type: String?,
    val uri: String?,
) : SpotifyUIModel
