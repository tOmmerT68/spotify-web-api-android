package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Artist
import nl.tommert.spotify.webapi.model.Items

@Parcelize
data class Artists(

    @SerializedName("artists")
    val artists: Items<Artist>
) : Parcelable
