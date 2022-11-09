package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Items

@Parcelize
data class NewAlbumReleases(

    @SerializedName("albums")
    val albums: Items<Album>
) : Parcelable
