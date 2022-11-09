package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bar(

    @SerializedName("start")
    val start: Number?,

    @SerializedName("duration")
    val duration: Number?,

    @SerializedName("confidence")
    val confidence: Number?,
) : Parcelable
