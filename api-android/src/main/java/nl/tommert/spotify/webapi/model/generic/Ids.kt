package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.IdsUIModel

@Parcelize
data class Ids(

    @SerializedName("ids")
    val ids: Array<String>,
) : SpotifyModel {

    override fun toUIModel(): IdsUIModel =
        IdsUIModel(ids.toList())
}
