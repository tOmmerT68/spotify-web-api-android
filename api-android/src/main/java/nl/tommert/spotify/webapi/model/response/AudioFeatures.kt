package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.AudioFeaturesUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class AudioFeatures(

    @SerializedName("audio_features")
    val audioFeatures: Array<AudioFeature>,
) : SpotifyModel {

    override fun toUIModel(): AudioFeaturesUIModel =
        AudioFeaturesUIModel(audioFeatures.map { it.toUIModel() })
}
