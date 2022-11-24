package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.ExternalIdsUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUrlUIModel

data class TrackUIModel(
    val album: AlbumUIModel?,
    val artists: List<ArtistUIModel>?,
    val availableMarkets: List<String>?,
    val diskNumber: Int?,
    val durationMs: Int?,
    val explicit: Boolean?,
    val externalIds: ExternalIdsUIModel?,
    val externalUrls: SpotifyUrlUIModel,
    val href: String,
    val id: String,
    val isPlayable: Boolean,
    val linkedFrom: TrackUIModel?,
    val restriction: RestrictionUIModel?,
    val name: String?,
    val popularity: Int?,
    val previewUrl: String?,
    val trackNumber: Int?,
    val type: String,
    val uri: String,
    val isLocal: Boolean,
) : SpotifyUIModel
