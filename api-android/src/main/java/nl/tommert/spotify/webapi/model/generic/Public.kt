package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.PublicUIModel

@Parcelize
data class Public(

    /**
     * Defaults to true. If true the playlist will be included in user's public playlists, if false it will remain private.
     */
    @SerializedName("public")
    val public: Boolean,
) : SpotifyModel {

    override fun toUIModel(): PublicUIModel =
        PublicUIModel(public)
}
