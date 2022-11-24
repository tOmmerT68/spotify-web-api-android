package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class ChapterUIModel(
    val audioPreviewUrl: String,
    val chapterNumber: Int,
    val description: String,
    val htmlDescription: String,
    val durationMs: Int,
    val explicit: Boolean,
    val externalUrls: SpotifyUrlUIModel,
    val href: String,
    val id: String,
    val images: List<ImageUIModel>,
    val isPlayable: Boolean,
    val languages: List<String>,
    val name: String,
    val releaseDate: String,
    val releaseDatePrecision: String,
    val resumePoint: ResumePointUIModel,
    val type: String,
    val uri: String,
    val restrictions: RestrictionUIModel?,
    val audiobook: AudiobookUIModel,
) : SpotifyUIModel
