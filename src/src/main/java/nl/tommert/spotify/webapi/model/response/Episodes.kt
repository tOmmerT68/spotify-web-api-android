package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Episode

@Parcelize
data class Episodes(

    @SerializedName("episodes")
    val episodes: Array<Episode>,
) : Parcelable
