package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.ItemUIModel
import nl.tommert.spotify.webapi.model.response.Artist
import nl.tommert.spotify.webapi.model.response.Restriction
import nl.tommert.spotify.webapi.model.response.Album

@Parcelize
data class Item(

    /**
     * The album on which the track appears. The album object includes a link in href to full information about the album.
     */
    @SerializedName("album")
    val album: Album?,

    /**
     * The artists who performed the track. Each artist object includes a link in href to more detailed information about the artist.
     */
    @SerializedName("artists")
    val artists: Array<Artist>?,

    /**
     * A list of the countries in which the track can be played, identified by their ISO 3166-1 alpha-2 code.
     */
    @SerializedName("available_markets")
    val availableMarkets: Array<String>?,

    /**
     * The disc number (usually 1 unless the album consists of more than one disc).
     */
    @SerializedName("disc_number")
    val discNumber: Int?,

    /**
     * The track length in milliseconds.
     */
    @SerializedName("duration_ms")
    val durationMs: Int?,

    /**
     * Whether or not the track has explicit lyrics ( true = yes it does; false = no it does not OR unknown).
     */
    @SerializedName("explicit")
    val explicit: Boolean?,

    /**
     * Known external IDs for the track.
     */
    @SerializedName("external_ids")
    val externalIds: ExternalIds?,

    /**
     * Known external URLs for this track.
     */
    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl?,

    /**
     * A link to the Web API endpoint providing full details of the track.
     */
    @SerializedName("href")
    val href: String?,

    /**
     * The Spotify ID for the track.
     */
    @SerializedName("id")
    val id: String?,

    /**
     * Part of the response when Track Relinking is applied. If true, the track is playable in the given market. Otherwise false.
     */
    @SerializedName("is_playable")
    val isPlayable: Boolean?,

    /**
     * Part of the response when Track Relinking is applied, and the requested track has been replaced with different track.
     * The track in the linked_from object contains information about the originally requested track.
     */
    @SerializedName("linked_from")
    val linkedFrom: Item?,

    /**
     * Included in the response when a content restriction is applied.
     */
    @SerializedName("restrictions")
    val restriction: Restriction?,

    /**
     * The name of the track.
     */
    @SerializedName("name")
    val name: String?,

    /**
     * The popularity of the track. The value will be between 0 and 100, with 100 being the most popular.
     * The popularity of a track is a value between 0 and 100, with 100 being the most popular.
     * The popularity is calculated by algorithm and is based, in the most part, on the total number of plays the track has had and how recent those plays are.
     * Generally speaking, songs that are being played a lot now will have a higher popularity than songs that were played a lot in the past.
     * Duplicate tracks (e.g. the same track from a single and an album) are rated independently. Artist and album popularity is derived mathematically from track popularity.
     */
    @SerializedName("popularity")
    val popularity: Int?,

    /**
     * A link to a 30 second preview (MP3 format) of the track. Can be null
     */
    @SerializedName("preview_url")
    val previewUrl: String?,

    /**
     * The number of the track. If an album has several discs, the track number is the number on the specified disc.
     */
    @SerializedName("track_number")
    val trackNumber: Int?,

    /**
     * The object type: "track".
     */
    @SerializedName("type")
    val type: String?,

    /**
     * The Spotify URI for the track.
     */
    @SerializedName("uri")
    val uri: String?,

    /**
     * Whether or not the track is from a local file.
     */
    @SerializedName("is_local")
    val isLocal: Boolean?,
) : SpotifyModel {

    override fun toUIModel(): ItemUIModel =
        ItemUIModel(
            album?.toUIModel(),
            artists?.map { it.toUIModel() },
            availableMarkets?.toList(),
            discNumber,
            durationMs,
            explicit,
            externalIds?.toUIModel(),
            externalUrls?.toUIModel(),
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
