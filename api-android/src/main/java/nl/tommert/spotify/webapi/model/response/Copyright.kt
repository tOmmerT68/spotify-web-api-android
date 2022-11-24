package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.response.CopyrightUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Copyright(

    @SerializedName("text")
    val text: String?,

    @SerializedName("type")
    val type: String?,
) : SpotifyModel {

    override fun toUIModel(): CopyrightUIModel =
        CopyrightUIModel(text, type)
}
