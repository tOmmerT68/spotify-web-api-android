package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.RestrictionUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Restriction(

    @SerializedName("reason")
    val reason: String?,
) : SpotifyModel {

    override fun toUIModel(): RestrictionUIModel =
        RestrictionUIModel(reason)
}
