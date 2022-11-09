package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tracks(

    @SerializedName("tracks")
    val tracks: Array<Track>,
) : Parcelable
