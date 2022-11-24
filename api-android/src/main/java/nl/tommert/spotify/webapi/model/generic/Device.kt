package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.DeviceUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel

@Parcelize
data class Device(

    /**
     * The device ID.
     */
    @SerializedName("id")
    val id: String?,

    /**
     * If this device is the currently active device.
     */
    @SerializedName("is_active")
    val isActive: Boolean?,

    /**
     * If this device is currently in a private session.
     */
    @SerializedName("is_private_session")
    val isPrivateSession: Boolean?,

    /**
     * Whether controlling this device is restricted. At present if this is "true" then no Web API commands will be accepted by this device.
     */
    @SerializedName("is_restricted")
    val isRestricted: Boolean?,

    /**
     * A human-readable name for the device. Some devices have a name that the user can configure (e.g. "Loudest speaker") and some devices have a generic name associated with the manufacturer or device model.
     */
    @SerializedName("name")
    val name: String?,

    /**
     * Device type, such as "computer", "smartphone" or "speaker".
     */
    @SerializedName("type")
    val type: String?,

    /**
     * The current volume in percent.
     */
    @SerializedName("volume_percent")
    val volumePercent: Int?,
) : SpotifyModel {

    override fun toUIModel(): DeviceUIModel =
        DeviceUIModel(id, isActive, isPrivateSession, isRestricted, name, type, volumePercent)
}
