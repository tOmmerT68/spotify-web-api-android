package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.SnapshotUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Snapshot(

    @SerializedName("snapshot_id")
    val snapshotId: String,
) : SpotifyModel {

    override fun toUIModel(): SnapshotUIModel =
        SnapshotUIModel(snapshotId)
}
