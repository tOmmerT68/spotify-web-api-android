package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Artist
import nl.tommert.spotify.webapi.model.Audiobook
import nl.tommert.spotify.webapi.model.Episode
import nl.tommert.spotify.webapi.model.Items
import nl.tommert.spotify.webapi.model.Show

@Parcelize
data class SearchResult(

    @SerializedName("tracks")
    val tracks: Items<Track>?,

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
