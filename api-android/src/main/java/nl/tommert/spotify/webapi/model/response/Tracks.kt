package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.TracksUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Tracks(

    @SerializedName("tracks")
    val tracks: Array<Track>,
) : SpotifyModel {

    override fun toUIModel(): TracksUIModel =
        TracksUIModel(tracks.map { it.toUIModel() })
}
