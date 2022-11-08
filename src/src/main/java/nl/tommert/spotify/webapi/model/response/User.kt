package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Image
import nl.tommert.spotify.webapi.model.generic.ExplicitContent
import nl.tommert.spotify.webapi.model.generic.Followers
import nl.tommert.spotify.webapi.model.generic.SpotifyUrl

@Parcelize
data class User(

    /**
     * The country of the user, as set in the user's account profile. An ISO 3166-1 alpha-2 country code.
     * This field is only available when the current user has granted access to the user-read-private scope.
     */
    @SerializedName("country")
    val country: String,

    /**
     * The name displayed on the user's profile. null if not available.
     */
    @SerializedName("display_name")
    val displayName: String?,

    /**
     * The user's email address, as entered by the user when creating their account. Important! This email address is unverified; there is no proof that it actually belongs to the user.
     * This field is only available when the current user has granted access to the user-read-email scope.
     */
    @SerializedName("email")
    val email: String,

    /**
     * The user's explicit content settings. This field is only available when the current user has granted access to the user-read-private scope.
     */
    @SerializedName("explicit_content")
    val explicitContent: ExplicitContent,

    /**
     * Known external URLs for this user.
     */
    @SerializedName("external_urls")
    val externalUrls: SpotifyUrl,

    /**
     * Information about the followers of the user.
     */
    @SerializedName("followers")
    val followers: Followers,

    /**
     * A link to the Web API endpoint for this user.
     */
    @SerializedName("href")
    val href: String,

    /**
     * The Spotify user ID for the user.
     */
    @SerializedName("id")
    val id: String,

    /**
     * The user's profile image.
     */
    @SerializedName("images")
    val images: Array<Image>,

    /**
     * The user's Spotify subscription level: "premium", "free", etc. (The subscription level "open" can be considered the same as "free".)
     * This field is only available when the current user has granted access to the user-read-private scope.
     */
    @SerializedName("product")
    val product: String,

    /**
     * The object type: "user"
     */
    @SerializedName("type")
    val type: String,

    /**
     * The Spotify URI for the user.
     */
    @SerializedName("uri")
    val uri: String,
) : Parcelable
