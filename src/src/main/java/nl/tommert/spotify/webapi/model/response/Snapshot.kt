package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Snapshot(

    @SerializedName("snapshot_id")
    val snapshotId: String,
) : Parcelable
