package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.response.NarratorUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Narrator(

    @SerializedName("name")
    val name: String,
) : SpotifyModel {

    override fun toUIModel(): NarratorUIModel =
        NarratorUIModel(name)
}
