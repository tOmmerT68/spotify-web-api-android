package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.Offset

@Parcelize
data class PlayRequest(

    /**
     * Spotify URI of the context to play. Valid contexts are albums, artists & playlists.
     */
    @SerializedName("context_uri")
    val contextUri: String?,

    /**
     * A JSON array of the Spotify track URIs to play.
     */
    @SerializedName("uris")
    val uris: Array<String>?,

    /**
     * Indicates from where in the context playback should start.
     * Only available when context_uri corresponds to an album or playlist object "position" is zero based and can’t be negative.
     */
    @SerializedName("offset")
    val offset: Offset?,

    /**
     * integer
     */
    @SerializedName("position_ms")
    val positionMs: Int?,
) : Parcelable
