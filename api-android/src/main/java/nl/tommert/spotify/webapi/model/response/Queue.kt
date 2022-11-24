package nl.tommert.spotify.webapi.model.response

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.QueueUIModel
import nl.tommert.spotify.webapi.model.generic.Item
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Queue(

    @SerializedName("currently_playing")
    val currentlyPlaying: Item,

    @SerializedName("queue")
    val queue: Item,
) : SpotifyModel {

    override fun toUIModel(): QueueUIModel =
        QueueUIModel(currentlyPlaying.toUIModel(), queue.toUIModel())
}
