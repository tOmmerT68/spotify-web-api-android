package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.AudiobooksUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Audiobooks(

    @SerializedName("audiobooks")
    val audiobooks: Array<Audiobook>,
) : SpotifyModel {

    override fun toUIModel(): AudiobooksUIModel =
        AudiobooksUIModel(audiobooks.map { it.toUIModel() })
}
