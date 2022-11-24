package nl.tommert.spotify.webapi.model.generic

import android.os.Parcelable
import nl.tommert.spotify.api.model.generic.SpotifyUIModel

interface SpotifyModel : Parcelable {

    fun toUIModel(): SpotifyUIModel
}
