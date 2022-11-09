package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.generic.Bar
import nl.tommert.spotify.webapi.model.generic.Meta
import nl.tommert.spotify.webapi.model.generic.Beat
import nl.tommert.spotify.webapi.model.generic.Section
import nl.tommert.spotify.webapi.model.generic.Segment
import nl.tommert.spotify.webapi.model.generic.Tatum
import nl.tommert.spotify.webapi.model.generic.TrackAnalysis

@Parcelize
data class AudioAnalysis(

    @SerializedName("meta")
    val meta: Meta,

    @SerializedName("track")
    val track: TrackAnalysis,

    @SerializedName("bars")
    val bars: Array<Bar>,

    @SerializedName("beats")
    val beats: Array<Beat>,

    @SerializedName("sections")
    val sections: Array<Section>,

    @SerializedName("segments")
    val segments: Array<Segment>,

    @SerializedName("tatums")
    val tatums: Array<Tatum>,
) : Parcelable
