package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ArtistUIModel
import nl.tommert.spotify.webapi.model.generic.Followers
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Artist(

    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl?,

    @SerializedName("followers")
    val followers: Followers?,

    @SerializedName("genres")
    val genres: Array<String>?,

    @SerializedName("href")
    val href: String?,

    @SerializedName("id")
    val id: String?,

    @SerializedName("images")
    val images: Array<Image>?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("popularity")
    val popularity: Int?,

    @SerializedName("type")
    val type: String?,

    @SerializedName("uri")
    val uri: String?,
) : SpotifyModel {

    override fun toUIModel(): ArtistUIModel =
        ArtistUIModel(
            externalUrls?.toUIModel(),
            followers?.toUIModel(),
            genres?.toList(),
            href,
            id,
            images?.map { it.toUIModel() },
            name,
            popularity,
            type,
            uri,
        )
}
