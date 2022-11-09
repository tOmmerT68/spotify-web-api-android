package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Artist
import nl.tommert.spotify.webapi.model.Restriction
import nl.tommert.spotify.webapi.model.generic.ExternalIds
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Track(

    @SerializedName("album")
    val album: Album?,

    @SerializedName("artists")
    val artists: Array<Artist>?,

    @SerializedName("available_markets")
    val availableMarkets: Array<String>?,

    @SerializedName("disc_number")
    val diskNumber: Int?,

    @SerializedName("duration_ms")
    val durationMs: Int?,

    @SerializedName("explicit")
    val explicit: Boolean?,

    @SerializedName("external_ids")
    val externalIds: ExternalIds,

    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl,

    @SerializedName("href")
    val href: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("is_playable")
    val isPlayable: Boolean,

    @SerializedName("linked_from")
    val linkedFrom: Track?,

    @SerializedName("restrictions")
    val restriction: Restriction?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("popularity")
    val popularity: Int?,

    @SerializedName("preview_url")
    val previewUrl: String?,

    @SerializedName("track_number")
    val trackNumber: Int?,

    @SerializedName("type")
    val type: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("is_local")
    val isLocal: Boolean,
) : Parcelable
