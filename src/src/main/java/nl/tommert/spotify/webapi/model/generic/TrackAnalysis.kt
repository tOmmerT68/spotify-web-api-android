package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrackAnalysis(

    @SerializedName("num_samples")
    val numSamples: Int?,

    @SerializedName("duration")
    val duration: Number?,

    @SerializedName("sample_md5")
    val sampleMd5: String?,

    @SerializedName("offset_seconds")
    val offsetSeconds: Int?,

    @SerializedName("window_seconds")
    val windowSeconds: Int?,

    @SerializedName("analysis_sample_rate")
    val analysisSampleRate: Int?,

    @SerializedName("analysis_channels")
    val analysisChannel: Int?,

    @SerializedName("end_of_fade_in")
    val endOfFadeIn: Number?,

    @SerializedName("start_of_fade_out")
    val startOfFadeOut: Number?,

    @SerializedName("tempo")
    val tempo: Float?,

    @SerializedName("tempo_confidence")
    val tempoConfidence: Float?,

    @SerializedName("time_signature")
    val timeSignature: Int?,

    @SerializedName("time_signature_confidence")
    val timeSignatureConfidence: Number?,

    @SerializedName("key")
    val key: Int?,

    @SerializedName("key_confidence")
    val keyConfidence: Number?,

    @SerializedName("mode")
    val mode: Int?,

    @SerializedName("mode_confidence")
    val modeConfidence: Number?,

    @SerializedName("codestring")
    val codeString: String?,

    @SerializedName("code_version")
    val codeVersion: Number?,

    @SerializedName("echoprintstring")
    val echoPrintString: String?,

    @SerializedName("echoprint_version")
    val echoPrintVersion: Number?,

    @SerializedName("synchstring")
    val synchString: String?,

    @SerializedName("synch_version")
    val synchVersion: Number?,

    @SerializedName("rhythmstring")
    val rhythmString: String?,

    @SerializedName("rhythm_version")
    val rhythmVersion: Number?,
) : Parcelable
