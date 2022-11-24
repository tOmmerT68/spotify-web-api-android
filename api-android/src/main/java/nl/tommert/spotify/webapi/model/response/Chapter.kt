package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ChapterUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Chapter(

    @SerializedName("audio_preview_url")
    val audioPreviewUrl: String,

    @SerializedName("chapter_number")
    val chapterNumber: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("html_description")
    val htmlDescription: String,

    @SerializedName("duration_ms")
    val durationMs: Int,

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

    @SerializedName("is_playable")
    val isPlayable: Boolean,

    @SerializedName("languages")
    val languages: Array<String>,

    @SerializedName("name")
    val name: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("release_date_precision")
    val releaseDatePrecision: String,

    @SerializedName("resume_point")
    val resumePoint: ResumePoint,

    @SerializedName("type")
    val type: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("restrictions")
    val restrictions: Restriction?,

    @SerializedName("audiobook")
    val audiobook: Audiobook,
) : SpotifyModel {
    override fun toUIModel(): ChapterUIModel =
        ChapterUIModel(
            audioPreviewUrl,
            chapterNumber,
            description,
            htmlDescription,
            durationMs,
            explicit,
            externalUrls.toUIModel(),
            href,
            id,
            images.map { it.toUIModel() },
            isPlayable,
            languages.toList(),
            name,
            releaseDate,
            releaseDatePrecision,
            resumePoint.toUIModel(),
            type,
            uri,
            restrictions?.toUIModel(),
            audiobook.toUIModel(),
        )
}
