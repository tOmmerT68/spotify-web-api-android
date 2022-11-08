package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Markets(

    @SerializedName("markets")
    val markets: Array<String>,
) : Parcelable
