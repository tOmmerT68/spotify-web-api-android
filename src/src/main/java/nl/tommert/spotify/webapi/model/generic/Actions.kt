package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Actions(

    /**
     * Interrupting playback.
     */
    @SerializedName("interrupting_playback")
    val interruptingPlayback: Boolean?,

    /**
     * Pausing.
     */
    @SerializedName("pausing")
    val pausing: Boolean?,

    /**
     * Resuming.
     */
    @SerializedName("resuming")
    val resuming: Boolean?,

    /**
     * Seeking playback location.
     */
    @SerializedName("seeking")
    val seeking: Boolean?,

    /**
     * Skipping to the next context.
     */
    @SerializedName("skipping_next")
    val skippingNext: Boolean?,

    /**
     * Skipping to the previous context.
     */
    @SerializedName("skipping_prev")
    val skippingPrev: Boolean?,

    /**
     * Toggling repeat context flag.
     */
    @SerializedName("toggling_repeat_context")
    val togglingRepeatContext: Boolean?,

    /**
     * Toggling shuffle flag.
     */
    @SerializedName("toggling_shuffle")
    val togglingShuffle: Boolean?,

    /**
     * Toggling repeat track flag.
     */
    @SerializedName("toggling_repeat_track")
    val togglingRepeatTrack: Boolean?,

    /**
     * Transfering playback between devices.
     */
    @SerializedName("transferring_playback")
    val transferringPlayback: Boolean?,
) : Parcelable
