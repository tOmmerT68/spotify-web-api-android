package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddTracksToPlaylistRequest(

    /**
     * A JSON array of the Spotify URIs to add. For example: {"uris": ["spotify:track:4iV5W9uYEdYUVa79Axb7Rh","spotify:track:1301WleyT98MSxVHPZCA6M", "spotify:episode:512ojhOuo1ktJprKbVcKyQ"]}
     * A maximum of 100 items can be added in one request.
     */
    @SerializedName("uris")
    val uris: Array<String>,

    /**
     * The position to insert the items, a zero-based index. For example, to insert the items in the first position: position=0; to insert the items in the third position: position=2.
     * If omitted, the items will be appended to the playlist. Items are added in the order they appear in the uris array.
     * For example: {"uris": ["spotify:track:4iV5W9uYEdYUVa79Axb7Rh","spotify:track:1301WleyT98MSxVHPZCA6M"], "position": 3}
     */
    @SerializedName("position")
    val position: Int,
) : Parcelable
