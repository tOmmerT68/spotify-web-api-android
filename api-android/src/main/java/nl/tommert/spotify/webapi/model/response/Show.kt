package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ShowUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Show(

    @SerializedName("available_markets")
    val availableMarkets: Array<String>,

    @SerializedName("copyrights")
    val copyrights: Array<Copyright>,

    @SerializedName("description")
    val description: String,

    @SerializedName("html_description")
    val htmlDescription: String,

    @SerializedName("explicit")
    val explicit: Boolean,

    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl,

    @SerializedName("href")
    val href: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("images")
    val images: Array<Image>,

    @SerializedName("is_externally_hosted")
    val isExternallyHosted: Boolean,

    @SerializedName("languages")
    val languages: Array<String>,

    @SerializedName("media_type")
    val mediaType: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("episodes")
    val episodes: Items<Episode>,
) : SpotifyModel {

    override fun toUIModel(): ShowUIModel =
        ShowUIModel(
            availableMarkets.toList(),
            copyrights.map { it.toUIModel() },
            description,
            htmlDescription,
            explicit,
            externalUrls.toUIModel(),
            href,
            id,
            images.map { it.toUIModel() },
            isExternallyHosted,
            languages.toList(),
            mediaType,
            name,
            publisher,
            type,
            uri,
            episodes.toUIModel(),
        )
}
