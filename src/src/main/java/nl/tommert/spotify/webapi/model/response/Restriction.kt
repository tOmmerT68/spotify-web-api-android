package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restriction(

    @SerializedName("reason")
    val reason: String?,
) : Parcelable
