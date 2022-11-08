package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Public(

    /**
     * Defaults to true. If true the playlist will be included in user's public playlists, if false it will remain private.
     */
    @SerializedName("public")
    val public: Boolean,
) : Parcelable
