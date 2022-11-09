package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.Item

@Parcelize
data class Queue(

    @SerializedName("currently_playing")
    val currentlyPlaying: Item,

    @SerializedName("queue")
    val queue: Item,
) : Parcelable
