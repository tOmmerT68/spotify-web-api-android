package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Section(

    @SerializedName("start")
    val start: Number?,

    @SerializedName("duration")
    val duration: Number?,

    @SerializedName("confidence")
    val confidence: Number?,

    @SerializedName("loudness")
    val loudness: Number?,

    @SerializedName("tempo")
    val tempo: Number?,

    @SerializedName("tempo_confidence")
    val tempoConfidence: Number?,

    @SerializedName("key")
    val key: Int?,

    @SerializedName("key_confidence")
    val keyConfidence: Number?,

    @SerializedName("mode")
    val mode: Number?,

    @SerializedName("mode_confidence")
    val modeConfidence: Number?,

    @SerializedName("time_signature")
    val timeSignature: Int?,

    @SerializedName("time_signature_confidence")
    val timeSignatureConfidence: Number?,
) : Parcelable
