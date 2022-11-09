package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExternalIds(

    @SerializedName("isrc")
    val isrc: String?,

    @SerializedName("ean")
    val ean: String?,

    @SerializedName("upc")
    val upc: String?,
) : Parcelable
