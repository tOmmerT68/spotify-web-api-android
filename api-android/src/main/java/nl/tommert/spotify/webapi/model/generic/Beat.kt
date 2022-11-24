package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.BeatUIModel

@Parcelize
data class Beat(

    @SerializedName("start")
    val start: Number?,

    @SerializedName("duration")
    val duration: Number?,

    @SerializedName("confidence")
    val confidence: Number?,
) : SpotifyModel {

    override fun toUIModel(): BeatUIModel =
        BeatUIModel(start, duration, confidence)
}
