package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExplicitContent(

    /**
     * When true, indicates that explicit content should not be played.
     */
    @SerializedName("filter_enabled")
    val filterEnabled: Boolean,

    /**
     * When true, indicates that the explicit content setting is locked and can't be changed by the user.
     */
    @SerializedName("filter_locked")
    val filterLocked: Boolean,
) : Parcelable
