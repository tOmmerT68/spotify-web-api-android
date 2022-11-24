package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.UriUIModel

@Parcelize
data class Uri(

    /**
     * Spotify URI
     */
    @SerializedName("uri")
    val uri: String,
) : SpotifyModel {

    override fun toUIModel(): UriUIModel =
        UriUIModel(uri)
}
