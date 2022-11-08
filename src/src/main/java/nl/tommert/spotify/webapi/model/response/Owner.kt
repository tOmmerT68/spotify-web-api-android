package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.Followers
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
) : Parcelable
