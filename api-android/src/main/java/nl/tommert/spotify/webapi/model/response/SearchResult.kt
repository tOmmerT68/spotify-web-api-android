package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.SearchResultUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

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
) : SpotifyModel {

    override fun toUIModel(): SearchResultUIModel =
        SearchResultUIModel(
            tracks?.toUIModel(),
            artists?.toUIModel(),
            albums?.toUIModel(),
            playlists?.toUIModel(),
            shows?.toUIModel(),
            episodes?.toUIModel(),
            audiobooks?.toUIModel(),
        )
}
