package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.Uri
import nl.tommert.spotify.webapi.model.response.Snapshot

@Parcelize
data class RemovePlaylistItemsRequest(

    /**
     * An array of objects containing Spotify URIs of the tracks or episodes to remove.
     * For example: { "tracks": [{ "uri": "spotify:track:4iV5W9uYEdYUVa79Axb7Rh" },{ "uri": "spotify:track:1301WleyT98MSxVHPZCA6M" }] }.
     * A maximum of 100 objects can be sent at once.
     */
    @SerializedName("tracks")
    val tracks: Array<Uri>,

    /**
     * The playlist's snapshot ID against which you want to make the changes.
     * The API will validate that the specified items exist and in the specified positions and make the changes, even if more recent changes have been made to the playlist.
     */
    @SerializedName("snapshot_id")
    val snapshotId: Snapshot,
) : Parcelable
