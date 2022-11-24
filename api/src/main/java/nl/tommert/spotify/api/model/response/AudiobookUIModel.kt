package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class AudiobookUIModel(
    val authors: List<String>,
    val availableMarkets: List<String>,
    val copyrights: List<CopyrightUIModel>,
    val description: String,
    val htmlDescription: String,
    val explicit: Boolean,
    val externalUrls: SpotifyUrlUIModel,
    val href: String,
    val id: String,
    val images: List<ImageUIModel>,
    val languages: List<String>,
    val mediaType: String,
    val name: String,
    val narrators: NarratorUIModel,
    val publisher: String,
    val type: String,
    val uri: String,
    val totalChapters: Int,
    val chapters: ItemsUIModel<SpotifyUIModel>,
) : SpotifyUIModel
