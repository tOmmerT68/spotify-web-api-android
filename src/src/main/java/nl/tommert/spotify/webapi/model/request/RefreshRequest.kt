package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RefreshRequest(

    @SerializedName("grant_type")
    val grantType: String = "refresh_token",

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("client_id")
    val clientId: String,
) : Parcelable
