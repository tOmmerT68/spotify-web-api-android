package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Artist
import nl.tommert.spotify.webapi.model.Image
import nl.tommert.spotify.webapi.model.Items
import nl.tommert.spotify.webapi.model.Restriction
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Album(

    @SerializedName("album_type")
    val albumType: String,

    @SerializedName("total_tracks")
    val totalTracks: Int,

    @SerializedName("available_markets")
    val availableMarkets: Array<String>,

    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl,

    @SerializedName("href")
    val href: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("images")
    val images: Array<Image>,

    @SerializedName("name")
    val name: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("release_date_precision")
    val releaseDatePrecision: String,

    @SerializedName("restrictions")
    val restrictions: Restriction?,

    @SerializedName("type")
    val type: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("artists")
    val artists: Array<Artist>?,

    @SerializedName("tracks")
    val items: Items<Track>?,
) : Parcelable
