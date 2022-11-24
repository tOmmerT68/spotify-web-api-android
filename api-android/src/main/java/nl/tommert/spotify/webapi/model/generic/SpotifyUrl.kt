package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

@Parcelize
data class SpotifyUrl(

    /**
     * The Spotify URL for the object.
     */
    @SerializedName("spotify")
    val spotify: String?,
) : SpotifyModel {

    override fun toUIModel(): SpotifyUrlUIModel =
        SpotifyUrlUIModel(spotify)
}
