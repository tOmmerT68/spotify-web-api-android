package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpdatePlaylistItemsRequest(

    /**
     * A JSON array of the Spotify URIs to set. For example: {"uris": ["spotify:track:4iV5W9uYEdYUVa79Axb7Rh","spotify:track:1301WleyT98MSxVHPZCA6M", "spotify:episode:512ojhOuo1ktJprKbVcKyQ"]}
     * A maximum of 100 items can be added in one request.
     */
    @SerializedName("uris")
    val uris: Array<String>,

    /**
     * The position of the first item to be reordered.
     */
    @SerializedName("range_start")
    val rangeStart: Int,

    /**
     * The position where the items should be inserted.
     * To reorder the items to the end of the playlist, simply set insert_before to the position after the last item.
     */
    @SerializedName("insert_before")
    val insertBefore: Int,

    /**
     * The amount of items to be reordered. Defaults to 1 if not set.
     * The range of items to be reordered begins from the range_start position, and includes the range_length subsequent items.
     */
    @SerializedName("range_length")
    val rangeLength: Int,

    /**
     * The playlist's snapshot ID against which you want to make the changes.
     */
    @SerializedName("snapshot_id")
    val snapshotId: String,
) : Parcelable
