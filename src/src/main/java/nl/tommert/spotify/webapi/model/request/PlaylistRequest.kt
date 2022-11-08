package nl.tommert.spotify.webapi.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaylistRequest(

    /**
     * The new name for the playlist, for example "My New Playlist Title"
     */
    @SerializedName("name")
    val name: String?,

    /**
     * If true the playlist will be public, if false it will be private.
     */
    @SerializedName("public")
    val public: Boolean?,

    /**
     * If true, the playlist will become collaborative and other users will be able to modify the playlist in their Spotify client.
     */
    @SerializedName("collaborative")
    val collaborative: Boolean?,

    /**
     * Value for playlist description as displayed in Spotify Clients and in the Web API.
     */
    @SerializedName("description")
    val description: String,
) : Parcelable
