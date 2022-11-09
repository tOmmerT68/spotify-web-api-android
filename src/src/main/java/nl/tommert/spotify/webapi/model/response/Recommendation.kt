package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.Seed

@Parcelize
data class Recommendation(

    @SerializedName("seeds")
    val seeds: Array<Seed>,

    @SerializedName("tracks")
    val tracks: Array<Track>,
) : Parcelable
