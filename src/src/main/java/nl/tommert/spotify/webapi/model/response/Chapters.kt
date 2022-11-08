package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Chapter

@Parcelize
data class Chapters(

    @SerializedName("chapters")
    val chapters: Array<Chapter>,
) : Parcelable
