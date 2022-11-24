package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.TrackUIModel
import nl.tommert.spotify.webapi.model.generic.ExternalIds
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
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
) : SpotifyModel {

    override fun toUIModel(): TrackUIModel =
        TrackUIModel(
            album?.toUIModel(),
            artists?.map { it.toUIModel() },
            availableMarkets?.toList(),
            diskNumber,
            durationMs,
            explicit,
            externalIds.toUIModel(),
            externalUrls.toUIModel(),
            href,
            id,
            isPlayable,
            linkedFrom?.toUIModel(),
            restriction?.toUIModel(),
            name,
            popularity,
            previewUrl,
            trackNumber,
            type,
            uri,
            isLocal,
        )
}
