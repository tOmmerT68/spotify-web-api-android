package nl.tommert.spotify.api.model.generic

data class SectionUIModel(
    val start: Number?,
    val duration: Number?,
    val confidence: Number?,
    val loudness: Number?,
    val tempo: Number?,
    val tempoConfidence: Number?,
    val key: Int?,
    val keyConfidence: Number?,
    val mode: Number?,
    val modeConfidence: Number?,
    val timeSignature: Int?,
    val timeSignatureConfidence: Number?,
) : SpotifyUIModel
