package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.response.ChaptersUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Chapters(

    @SerializedName("chapters")
    val chapters: Array<Chapter>,
) : SpotifyModel {

    override fun toUIModel(): ChaptersUIModel =
        ChaptersUIModel(chapters.map { it.toUIModel() })
}
