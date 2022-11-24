package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.NewAlbumReleasesUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class NewAlbumReleases(

    @SerializedName("albums")
    val albums: Items<Album>,
) : SpotifyModel {

    override fun toUIModel(): NewAlbumReleasesUIModel =
        NewAlbumReleasesUIModel(albums.toUIModel())
}
