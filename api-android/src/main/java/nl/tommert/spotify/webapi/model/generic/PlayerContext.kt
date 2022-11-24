package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.PlayerContextUIModel

@Parcelize
data class PlayerContext(

    /**
     * The object type, e.g. "artist", "playlist", "album", "show".
     */
    @SerializedName("type")
    val type: String?,

    /**
     * A link to the Web API endpoint providing full details of the track.
     */
    @SerializedName("href")
    val href: String?,

    /**
     * External URLs for this context.
     */
    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl,

    /**
     * The Spotify URI for the context.
     */
    @SerializedName("uri")
    val uri: String,
) : SpotifyModel {

    override fun toUIModel(): PlayerContextUIModel =
        PlayerContextUIModel(type, href, externalUrls.toUIModel(), uri)
}
