package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ids(

    @SerializedName("ids")
    val ids: Array<String>,
) : Parcelable
