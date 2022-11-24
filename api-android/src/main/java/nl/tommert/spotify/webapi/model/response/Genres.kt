package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.GenresUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Genres(

    @SerializedName("genres")
    val genres: Array<String>,
) : SpotifyModel {

    override fun toUIModel(): GenresUIModel =
        GenresUIModel(genres.toList())
}
