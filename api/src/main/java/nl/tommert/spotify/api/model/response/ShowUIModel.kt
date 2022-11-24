package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class ShowUIModel(
    val availableMarkets: List<String>,
    val copyrights: List<CopyrightUIModel>,
    val description: String,
    val htmlDescription: String,
    val explicit: Boolean,
    val externalUrls: SpotifyUrlUIModel,
    val href: String,
    val id: String,
    val images: List<ImageUIModel>,
    val isExternallyHosted: Boolean,
    val languages: List<String>,
    val mediaType: String,
    val name: String,
    val publisher: String,
    val type: String,
    val uri: String,
    val episodes: ItemsUIModel<SpotifyUIModel>,
) : SpotifyUIModel
