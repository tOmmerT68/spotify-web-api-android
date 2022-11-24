package nl.tommert.spotify.api.model.generic

data class DeviceUIModel(
    val id: String?,
    val isActive: Boolean?,
    val isPrivateSession: Boolean?,
    val isRestricted: Boolean?,
    val name: String?,
    val type: String?,
    val volumePercent: Int?,
) : SpotifyUIModel
