package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.FollowersUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class PlaylistUIModel(
    val collaborative: Boolean?,
    val description: String?,
    val externalUrls: SpotifyUrlUIModel?,
    val followers: FollowersUIModel?,
    val href: String?,
    val id: String?,
    val images: List<ImageUIModel>?,
    val name: String?,
    val owner: OwnerUIModel?,
    val public: Boolean?,
    val snapshotId: String?,
    val tracks: ItemsUIModel<SpotifyUIModel>?,
    val type: String?,
    val uri: String?,
) : SpotifyUIModel
