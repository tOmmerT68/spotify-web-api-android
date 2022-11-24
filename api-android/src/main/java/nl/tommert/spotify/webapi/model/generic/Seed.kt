package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.SeedUIModel

@Parcelize
data class Seed(

    @SerializedName("afterFilteringSize")
    val afterFilteringSize: Int?,

    @SerializedName("afterRelinkingSize")
    val afterRelinkingSize: Int?,

    @SerializedName("href")
    val href: String?,

    @SerializedName("id")
    val id: String?,

    @SerializedName("initialPoolSize")
    val initialPoolSize: Int?,

    @SerializedName("type")
    val type: String?,
) : SpotifyModel {

    override fun toUIModel(): SeedUIModel =
        SeedUIModel(afterFilteringSize, afterRelinkingSize, href, id, initialPoolSize, type)
}
