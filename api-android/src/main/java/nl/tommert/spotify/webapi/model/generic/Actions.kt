package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.ActionsUIModel

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
) : SpotifyModel {

    override fun toUIModel(): ActionsUIModel =
        ActionsUIModel(
            interruptingPlayback,
            pausing,
            resuming,
            seeking,
            skippingNext,
            skippingPrev,
            togglingRepeatContext,
            togglingShuffle,
            togglingRepeatTrack,
            transferringPlayback,
        )
}
