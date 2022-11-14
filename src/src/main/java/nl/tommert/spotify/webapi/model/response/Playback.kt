package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.Actions
import nl.tommert.spotify.webapi.model.generic.Device
import nl.tommert.spotify.webapi.model.generic.Item
import nl.tommert.spotify.webapi.model.generic.PlayerContext

@Parcelize
data class Playback(

    /**
     * The device that is currently active.
     */
    @SerializedName("device")
    val device: Device?,

    /**
     * off, track, context
     */
    @SerializedName("repeat_state")
    val repeatState: String?,

    /**
     * If shuffle is on or off.
     */
    @SerializedName("shuffle_state")
    val shuffleState: String?,

    /**
     * A Context Object. Can be null.
     */
    @SerializedName("context")
    val context: PlayerContext?,

    /**
     * Unix Millisecond Timestamp when data was fetched.
     */
    @SerializedName("timestamp")
    val timestamp: Long?,

    /**
     * Progress into the currently playing track or episode. Can be null.
     */
    @SerializedName("progress_ms")
    val progressMs: Long?,

    /**
     * If something is currently playing, return true.
     */
    @SerializedName("is_playing")
    val isPlaying: Boolean?,

    @SerializedName("item")
    val item: Item?,

    /**
     * The object type of the currently playing item. Can be one of track, episode, ad or unknown.
     */
    @SerializedName("currently_playing_type")
    val currentlyPlayingType: String?,

    /**
     * Allows to update the user interface based on which playback actions are available within the current context.
     */
    @SerializedName("actions")
    val actions: Actions,
) : Parcelable
