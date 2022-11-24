package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.ExternalIdsUIModel

@Parcelize
data class ExternalIds(

    @SerializedName("isrc")
    val isrc: String?,

    @SerializedName("ean")
    val ean: String?,

    @SerializedName("upc")
    val upc: String?,
) : SpotifyModel {

    override fun toUIModel(): ExternalIdsUIModel =
        ExternalIdsUIModel(isrc, ean, upc)
}
