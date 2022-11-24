package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.RecommendationUIModel
import nl.tommert.spotify.webapi.model.generic.Seed
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Recommendation(

    @SerializedName("seeds")
    val seeds: Array<Seed>,

    @SerializedName("tracks")
    val tracks: Array<Track>,
) : SpotifyModel {

    override fun toUIModel(): RecommendationUIModel =
        RecommendationUIModel(seeds.map { it.toUIModel() }, tracks.map { it.toUIModel() })
}
