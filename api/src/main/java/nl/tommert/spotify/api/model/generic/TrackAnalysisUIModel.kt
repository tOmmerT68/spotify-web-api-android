package nl.tommert.spotify.api.model.generic

data class TrackAnalysisUIModel(
    val numSamples: Int?,
    val duration: Number?,
    val sampleMd5: String?,
    val offsetSeconds: Int?,
    val windowSeconds: Int?,
    val analysisSampleRate: Int?,
    val analysisChannel: Int?,
    val endOfFadeIn: Number?,
    val startOfFadeOut: Number?,
    val tempo: Float?,
    val tempoConfidence: Float?,
    val timeSignature: Int?,
    val timeSignatureConfidence: Number?,
    val key: Int?,
    val keyConfidence: Number?,
    val mode: Int?,
    val modeConfidence: Number?,
    val codeString: String?,
    val codeVersion: Number?,
    val echoPrintString: String?,
    val echoPrintVersion: Number?,
    val synchString: String?,
    val synchVersion: Number?,
    val rhythmString: String?,
    val rhythmVersion: Number?,
) : SpotifyUIModel