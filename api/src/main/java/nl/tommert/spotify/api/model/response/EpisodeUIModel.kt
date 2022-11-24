package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class EpisodeUIModel(
    val audioPreviewUrl: String,
    val description: String,
    val htmlDescription: String,
    val durationMs: Int,
    val explicit: Boolean,
    val externalUrls: SpotifyUIModel,
    val href: String,
    val id: String,
    val images: List<ImageUIModel>,
    val isExternallyHosted: Boolean,
    val isPlayable: Boolean,
    @Deprecated("This field is deprecated and might be removed in the future. Please use the languages field instead.")
    val language: String?,
    val languages: List<String>,
    val name: String,
    val releaseDate: String,
    val releaseDatePrecision: String,
    val resumePoint: ResumePointUIModel,
    val type: String,
    val uri: String,
    val restrictions: RestrictionUIModel?,
    val show: ShowUIModel,
) : SpotifyUIModel
