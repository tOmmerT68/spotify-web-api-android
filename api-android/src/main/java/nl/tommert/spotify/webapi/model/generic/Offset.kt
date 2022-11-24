package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.OffsetUIModel

@Parcelize
data class Offset(

    @SerializedName("position")
    val position: Int?,
) : SpotifyModel {

    override fun toUIModel(): OffsetUIModel =
        OffsetUIModel(position)
}
