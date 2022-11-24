package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.BarUIModel
import nl.tommert.spotify.api.model.generic.BeatUIModel
import nl.tommert.spotify.api.model.generic.MetaUIModel
import nl.tommert.spotify.api.model.generic.SectionUIModel
import nl.tommert.spotify.api.model.generic.SegmentUIModel
import nl.tommert.spotify.api.model.generic.SpotifyUIModel
import nl.tommert.spotify.api.model.generic.TatumUIModel
import nl.tommert.spotify.api.model.generic.TrackAnalysisUIModel

data class AudioAnalysisUIModel(
    val meta: MetaUIModel,
    val track: TrackAnalysisUIModel,
    val bars: List<BarUIModel>,
    val beats: List<BeatUIModel>,
    val sections: List<SectionUIModel>,
    val segments: List<SegmentUIModel>,
    val tatums: List<TatumUIModel>,
) : SpotifyUIModel
