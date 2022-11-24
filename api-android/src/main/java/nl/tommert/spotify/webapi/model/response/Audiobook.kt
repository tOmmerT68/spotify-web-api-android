package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.AudiobookUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Audiobook(

    @SerializedName("authors")
    val authors: Array<String>,

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

    @SerializedName("languages")
    val languages: Array<String>,

    @SerializedName("media_type")
    val mediaType: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("narrators")
    val narrators: Narrator,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("total_chapters")
    val totalChapters: Int,

    @SerializedName("chapters")
    val chapters: Items<Chapter>,
) : SpotifyModel {

    override fun toUIModel(): AudiobookUIModel =
        AudiobookUIModel(
            authors.toList(),
            availableMarkets.toList(),
            copyrights.map { it.toUIModel() },
            description,
            htmlDescription,
            explicit,
            externalUrls.toUIModel(),
            href,
            id,
            images.map { it.toUIModel() },
            languages.toList(),
            mediaType,
            name,
            narrators.toUIModel(),
            publisher,
            type,
            uri,
            totalChapters,
            chapters.toUIModel(),
        )
}
