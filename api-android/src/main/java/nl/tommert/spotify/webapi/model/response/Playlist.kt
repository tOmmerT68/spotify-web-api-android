package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.PlaylistUIModel
import nl.tommert.spotify.webapi.model.generic.Followers
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Playlist(

    @SerializedName("collaborative")
    val collaborative: Boolean?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl?,

    @SerializedName("followers")
    val followers: Followers?,

    @SerializedName("href")
    val href: String?,

    @SerializedName("id")
    val id: String?,

    @SerializedName("images")
    val images: Array<Image>?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("owner")
    val owner: Owner?,

    @SerializedName("public")
    val public: Boolean?,

    @SerializedName("snapshot_id")
    val snapshotId: String?,

    @SerializedName("tracks")
    val tracks: Items<Track>?,

    @SerializedName("type")
    val type: String?,

    @SerializedName("uri")
    val uri: String?,
) : SpotifyModel {

    override fun toUIModel(): PlaylistUIModel =
        PlaylistUIModel(
            collaborative,
            description,
            externalUrls?.toUIModel(),
            followers?.toUIModel(),
            href,
            id,
            images?.map { it.toUIModel() },
            name,
            owner?.toUIModel(),
            public,
            snapshotId,
            tracks?.toUIModel(),
            type,
            uri,
        )
}
