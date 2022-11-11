package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthorizationRequest(

    @SerializedName("grant_type")
    val grantType: String = "authorization_code",

    @SerializedName("code")
    val code: String,

    @SerializedName("redirect_uri")
    val redirectUri: String,
) : Parcelable
