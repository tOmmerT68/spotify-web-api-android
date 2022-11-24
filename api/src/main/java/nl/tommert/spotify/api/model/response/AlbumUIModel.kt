package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class AlbumUIModel(
    val albumType: String,
    val totalTracks: Int,
    val availableMarkets: List<String>,
    val externalUrls: SpotifyUrlUIModel,
    val href: String,
    val id: String,
    val images: List<ImageUIModel>,
    val name: String,
    val releaseDate: String,
    val releaseDatePrecision: String,
    val restrictions: RestrictionUIModel?,
    val type: String,
    val uri: String,
    val artists: List<ArtistUIModel>?,
    val items: ItemsUIModel<SpotifyUIModel>?,
) : SpotifyUIModel
