package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Show

@Parcelize
data class Shows(

    @SerializedName("shows")
    val shows: Array<Show>,
) : Parcelable
