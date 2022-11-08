package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResult(

    @SerializedName("tracks")
    val tracks: Items<Track>,

    @SerializedName("artists")
    val artists: Items<Artist>?,

    @SerializedName("albums")
    val albums: Items<Album>?,

    @SerializedName("playlists")
    val playlists: Items<Playlist>?,

    @SerializedName("shows")
    val shows: Items<Show>?,

    @SerializedName("episodes")
    val episodes: Items<Episode>?,

    @SerializedName("audiobooks")
    val audiobooks: Items<Audiobook>?,
) : Parcelable
