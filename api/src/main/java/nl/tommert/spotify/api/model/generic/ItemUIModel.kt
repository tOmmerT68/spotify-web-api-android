package nl.tommert.spotify.api.model.generic

import nl.tommert.spotify.api.model.response.AlbumUIModel
import nl.tommert.spotify.api.model.response.ArtistUIModel
import nl.tommert.spotify.api.model.response.RestrictionUIModel

data class ItemUIModel(
    val album: AlbumUIModel?,
    val artists: List<ArtistUIModel>?,
    val availableMarkets: List<String>?,
    val discNumber: Int?,
    val durationMs: Int?,
    val explicit: Boolean?,
    val externalIds: ExternalIdsUIModel?,
    val externalUrls: SpotifyUrlUIModel?,
    val href: String?,
    val id: String?,
    val isPlayable: Boolean?,
    val linkedFrom: ItemUIModel?,
    val restriction: RestrictionUIModel?,
    val name: String?,
    val popularity: Int?,
    val previewUrl: String?,
    val trackNumber: Int?,
    val type: String?,
    val uri: String?,
    val isLocal: Boolean?,
) : SpotifyUIModel
