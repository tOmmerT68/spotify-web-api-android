package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.AudioFeatureUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class AudioFeature(

    /**
     * A confidence measure from 0.0 to 1.0 of whether the track is acoustic. 1.0 represents high confidence the track is acoustic.
     */
    @SerializedName("acousticness")
    val acousticness: Float?,

    /**
     * A URL to access the full audio analysis of this track. An access token is required to access this data.
     */
    @SerializedName("analysis_url")
    val analysisUrl: String?,

    /**
     * Danceability describes how suitable a track is for dancing based on a combination of musical elements including tempo, rhythm stability, beat strength, and overall regularity.
     * A value of 0.0 is least danceable and 1.0 is most danceable.
     */
    @SerializedName("danceability")
    val danceability: Float?,

    /**
     * The duration of the track in milliseconds.
     */
    @SerializedName("duration_ms")
    val durationMs: Int?,

    /**
     * Energy is a measure from 0.0 to 1.0 and represents a perceptual measure of intensity and activity.
     * Typically, energetic tracks feel fast, loud, and noisy. For example, death metal has high energy, while a Bach prelude scores low on the scale.
     * Perceptual features contributing to this attribute include dynamic range, perceived loudness, timbre, onset rate, and general entropy.
     */
    @SerializedName("energy")
    val energy: Float?,

    /**
     * The Spotify ID for the track.
     */
    @SerializedName("id")
    val id: String?,

    /**
     * Predicts whether a track contains no vocals. "Ooh" and "aah" sounds are treated as instrumental in this context.
     * Rap or spoken word tracks are clearly "vocal". The closer the instrumentalness value is to 1.0, the greater likelihood the track contains no vocal content.
     * Values above 0.5 are intended to represent instrumental tracks, but confidence is higher as the value approaches 1.0.
     */
    @SerializedName("instrumentalness")
    val instrumentalness: Float?,

    /**
     * The key the track is in. Integers map to pitches using standard Pitch Class notation.
     * E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on. If no key was detected, the value is -1.
     */
    @SerializedName("key")
    val key: Int?,

    /**
     * Detects the presence of an audience in the recording. Higher liveness values represent an increased probability that the track was performed live.
     * A value above 0.8 provides strong likelihood that the track is live.
     */
    @SerializedName("liveness")
    val liveness: Float?,

    /**
     * The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track and are useful for comparing relative loudness of tracks.
     * Loudness is the quality of a sound that is the primary psychological correlate of physical strength (amplitude).
     * Values typically range between -60 and 0 db.
     */
    @SerializedName("loudness")
    val loudness: Float?,

    /**
     * Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic content is derived.
     * Major is represented by 1 and minor is 0.
     */
    @SerializedName("mode")
    val mode: Int?,

    /**
     * Speechiness detects the presence of spoken words in a track.
     * The more exclusively speech-like the recording (e.g. talk show, audio book, poetry), the closer to 1.0 the attribute value.
     * Values above 0.66 describe tracks that are probably made entirely of spoken words. Values between 0.33 and 0.66 describe tracks that may contain both music and speech, either in sections or layered, including such cases as rap music.
     * Values below 0.33 most likely represent music and other non-speech-like tracks.
     */
    @SerializedName("speechiness")
    val speechiness: Float?,

    /**
     * The overall estimated tempo of a track in beats per minute (BPM). In musical terminology, tempo is the speed or pace of a given piece and derives directly from the average beat duration.
     */
    @SerializedName("tempo")
    val tempo: Float?,

    /**
     * An estimated time signature. The time signature (meter) is a notational convention to specify how many beats are in each bar (or measure).
     * The time signature ranges from 3 to 7 indicating time signatures of "3/4", to "7/4".
     */
    @SerializedName("time_signature")
    val timeSignature: Int?,

    /**
     * A link to the Web API endpoint providing full details of the track.
     */
    @SerializedName("track_href")
    val trackHref: String?,

    /**
     * The object type.
     */
    @SerializedName("type")
    val type: String?,

    /**
     * The Spotify URI for the track.
     */
    @SerializedName("uri")
    val uri: String?,

    /**
     * A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track.
     * Tracks with high valence sound more positive (e.g. happy, cheerful, euphoric), while tracks with low valence sound more negative (e.g. sad, depressed, angry).
     */
    @SerializedName("valence")
    val valence: Float?,
) : SpotifyModel {

    override fun toUIModel(): AudioFeatureUIModel =
        AudioFeatureUIModel(
            acousticness,
            analysisUrl,
            danceability,
            durationMs,
            energy,
            id,
            instrumentalness,
            key,
            liveness,
            loudness,
            mode,
            speechiness,
            tempo,
            timeSignature,
            trackHref,
            type,
            uri,
            valence,
        )
}
