package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.ActionsUIModel
import nl.tommert.spotify.api.model.generic.DeviceUIModel
import nl.tommert.spotify.api.model.generic.ItemUIModel
import nl.tommert.spotify.api.model.generic.PlayerContextUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class PlaybackUIModel(
    val device: DeviceUIModel?,
    val repeatState: String?,
    val shuffleState: String?,
    val context: PlayerContextUIModel?,
    val timestamp: Long?,
    val progressMs: Long?,
    val isPlaying: Boolean?,
    val item: ItemUIModel?,
    val currentlyPlayingType: String?,
    val actions: ActionsUIModel,
) : SpotifyUIModel
