package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.api.model.response.ItemsUIModel
import nl.tommert.spotify.api.model.response.TrackUIModel
import nl.tommert.spotify.webapi.model.generic.SpotifyModel

@Parcelize
data class Items<T : SpotifyModel>(

    /**
     * A link to the Web API endpoint returning the full result of the request
     */
    @SerializedName("href")
    val href: String?,

    /**
     * The requested content
     */
    @SerializedName("items")
    val items: Array<T>,

    /**
     * The maximum number of items in the response (as set in the query or by default).
     */
    @SerializedName("limit")
    val limit: Int?,

    /**
     * URL to the next page of items.
     */
    @SerializedName("next")
    val next: String?,

    /**
     * The offset of the items returned (as set in the query or by default)
     */
    @SerializedName("offset")
    val offset: Int?,

    /**
     * URL to the previous page of items.
     */
    @SerializedName("previous")
    val previous: String?,

    /**
     * The total number of items available to return.
     */
    @SerializedName("total")
    val total: Int?,
) : Parcelable {

    fun toUIModel(): ItemsUIModel<TrackUIModel> =
        ItemsUIModel(
            href,
            items.map { (it as Track).toUIModel() },
            limit,
            next,
            offset,
            previous,
            total,
        )
}
