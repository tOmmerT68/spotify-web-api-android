package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpotifyUrl(

    /**
     * The Spotify URL for the object.
     */
    @SerializedName("spotify")
    val spotify: String?,
) : Parcelable
