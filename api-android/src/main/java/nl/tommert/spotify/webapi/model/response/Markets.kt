package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.MarketsUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Markets(

    @SerializedName("markets")
    val markets: Array<String>,
) : SpotifyModel {

    override fun toUIModel(): MarketsUIModel =
        MarketsUIModel(markets.toList())
}
