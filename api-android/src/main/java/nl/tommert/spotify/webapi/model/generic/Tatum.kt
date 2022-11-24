package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.TatumUIModel

@Parcelize
data class Tatum(

    @SerializedName("start")
    val start: Number?,

    @SerializedName("duration")
    val duration: Number?,

    @SerializedName("confidence")
    val confidence: Number?,
) : SpotifyModel {

    override fun toUIModel(): TatumUIModel =
        TatumUIModel(start, duration, confidence)
}
