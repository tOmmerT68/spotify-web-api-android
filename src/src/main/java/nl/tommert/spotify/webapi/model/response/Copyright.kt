package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Copyright(

    @SerializedName("text")
    val text: String?,

    @SerializedName("type")
    val type: String?,
) : Parcelable
