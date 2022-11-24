package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.SegmentUIModel

@Parcelize
data class Segment(

    @SerializedName("start")
    val start: Number?,

    @SerializedName("duration")
    val duration: Number?,

    @SerializedName("confidence")
    val confidence: Number?,

    @SerializedName("loudness_start")
    val loudnessStart: Number?,

    @SerializedName("loudness_max")
    val loudnessMax: Number?,

    @SerializedName("loudness_max_time")
    val loudnessMaxTime: Number?,

    @SerializedName("loudness_end")
    val loudnessEnd: Number?,

    @SerializedName("pitches")
    val pitches: Array<Number>?,

    @SerializedName("timbre")
    val timbre: Array<Number>?,
) : SpotifyModel {

    override fun toUIModel(): SegmentUIModel =
        SegmentUIModel(
            start,
            duration,
            confidence,
            loudnessStart,
            loudnessMax,
            loudnessMaxTime,
            loudnessEnd,
            pitches?.toList(),
            timbre?.toList(),
        )
}
