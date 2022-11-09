package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(

    @SerializedName("analyzer_version")
    val analyzerVersion: String?,

    @SerializedName("platform")
    val platform: String?,

    @SerializedName("detailed_status")
    val detailedStatus: String?,

    @SerializedName("status_code")
    val statusCode: Int?,

    @SerializedName("timestamp")
    val timestamp: Int?,

    @SerializedName("analysis_time")
    val analysisTime: Number?,

    @SerializedName("input_process")
    val inputProcess: String?,
) : Parcelable
