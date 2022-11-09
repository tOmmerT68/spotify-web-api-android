package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

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
) : Parcelable
