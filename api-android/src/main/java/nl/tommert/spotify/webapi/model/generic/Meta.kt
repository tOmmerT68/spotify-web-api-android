package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.MetaUIModel

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
) : SpotifyModel {

    override fun toUIModel(): MetaUIModel =
        MetaUIModel(analyzerVersion, platform, detailedStatus, statusCode, timestamp, analysisTime, inputProcess)
}
