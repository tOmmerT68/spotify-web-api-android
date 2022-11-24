package nl.tommert.spotify.webapi.model.generic

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.generic.FollowersUIModel

@Parcelize
data class Followers(

    /**
     * This will always be set to null, as the Web API does not support it at the moment.
     */
    @SerializedName("href")
    val href: String,

    /**
     * The total number of followers.
     */
    @SerializedName("total")
    val total: Int,
) : SpotifyModel {

    override fun toUIModel(): FollowersUIModel =
        FollowersUIModel(href, total)
}
