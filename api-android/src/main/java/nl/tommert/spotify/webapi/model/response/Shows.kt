package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ShowsUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Shows(

    @SerializedName("shows")
    val shows: Array<Show>,
) : SpotifyModel {

    override fun toUIModel(): ShowsUIModel =
        ShowsUIModel(shows.map { it.toUIModel() })
}
