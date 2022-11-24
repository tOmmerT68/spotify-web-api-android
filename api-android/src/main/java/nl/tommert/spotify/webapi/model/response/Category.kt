package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.CategoryUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Category(

    @SerializedName("href")
    val href: String,

    @SerializedName("icons")
    val icons: Array<Image>,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,
) : SpotifyModel {

    override fun toUIModel(): CategoryUIModel =
        CategoryUIModel(href, icons.map { it.toUIModel() }, id, name)
}
