package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ArtistsUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Artists(

    @SerializedName("artists")
    val artists: Items<Artist>,
) : SpotifyModel {

    override fun toUIModel(): ArtistsUIModel =
        ArtistsUIModel(artists.toUIModel())
}
