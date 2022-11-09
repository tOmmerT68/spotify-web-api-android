package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaybackRequest(

    /**
     * A JSON array containing the ID of the device on which playback should be started/transferred.
     */
    @SerializedName("device_ids")
    val deviceIds: Array<String>,

    /**
     * true: ensure playback happens on new device.
     * false or not provided: keep the current playback state.
     */
    @SerializedName("play")
    val play: Boolean,
) : Parcelable
