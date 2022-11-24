package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ResumePointUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class ResumePoint(

    @SerializedName("fully_played")
    val fullyPlayed: Boolean,

    @SerializedName("resume_position_ms")
    val resumePositionMs: Int,
) : SpotifyModel {
    override fun toUIModel(): ResumePointUIModel =
        ResumePointUIModel(fullyPlayed, resumePositionMs)
}
