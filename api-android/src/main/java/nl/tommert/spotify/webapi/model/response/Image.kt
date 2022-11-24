package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ImageUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Image(

    /**
     * The source URL of the image.
     */
    @SerializedName("url")
    val url: String,

    /**
     * The image height in pixels.
     */
    @SerializedName("height")
    val height: Int,

    /**
     * The image width in pixels.
     */
    @SerializedName("width")
    val width: Int,
) : SpotifyModel {

    override fun toUIModel(): ImageUIModel =
        ImageUIModel(url, height, width)
}
