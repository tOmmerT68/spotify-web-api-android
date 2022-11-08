package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

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
) : Parcelable
