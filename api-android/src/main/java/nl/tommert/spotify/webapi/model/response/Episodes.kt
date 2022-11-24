package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.EpisodesUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Episodes(

    @SerializedName("episodes")
    val episodes: Array<Episode>,
) : SpotifyModel {

    override fun toUIModel(): EpisodesUIModel =
        EpisodesUIModel(episodes.map { it.toUIModel() })
}
