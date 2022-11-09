package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudioFeatures(

    @SerializedName("audio_features")
    val audioFeatures: Array<AudioFeature>,
) : Parcelable
