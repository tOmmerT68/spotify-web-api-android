package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.OwnerUIModel
import nl.tommert.spotify.webapi.model.generic.Followers
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Owner(

    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl?,

    @SerializedName("followers")
    val followers: Followers?,

    @SerializedName("href")
    val href: String?,

    @SerializedName("id")
    val id: String?,

    @SerializedName("type")
    val type: String?,

    @SerializedName("uri")
    val uri: String?,
) : SpotifyModel {

    override fun toUIModel(): OwnerUIModel =
        OwnerUIModel(externalUrls?.toUIModel(), followers?.toUIModel(), href, id, type, uri)
}
