package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Refresh(

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("token_type")
    val tokenType: String,

    @SerializedName("scope")
    val scope: String,

    @SerializedName("expires_in")
    val expiresIn: Int,
) : Parcelable
