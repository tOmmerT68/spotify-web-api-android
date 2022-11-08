package nl.tommert.spotify.webapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(

    @SerializedName("href")
    val href: String,

    @SerializedName("icons")
    val icons: Array<Image>,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,
) : Parcelable
