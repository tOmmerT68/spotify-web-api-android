package nl.tommert.spotify.api.model.generic

data class ActionsUIModel(
    val interruptingPlayback: Boolean?,
    val pausing: Boolean?,
    val resuming: Boolean?,
    val seeking: Boolean?,
    val skippingNext: Boolean?,
    val skippingPrev: Boolean?,
    val togglingRepeatContext: Boolean?,
    val togglingShuffle: Boolean?,
    val togglingRepeatTrack: Boolean?,
    val transferringPlayback: Boolean?,
) : SpotifyUIModel
