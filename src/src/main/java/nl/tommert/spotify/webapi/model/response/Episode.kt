package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class Episode(

    @SerializedName("audio_preview_url")
    val audioPreviewUrl: String,

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

    @SerializedName("is_externally_hosted")
    val isExternallyHosted: Boolean,

    @SerializedName("is_playable")
    val isPlayable: Boolean,

    @Deprecated("This field is deprecated and might be removed in the future. Please use the languages field instead.")
    @SerializedName("language")
    val language: String,

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

    @SerializedName("show")
    val show: Show,
) : Parcelable
