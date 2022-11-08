package nl.tommert.spotify.webapi.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import nl.tommert.spotify.webapi.model.Audiobook

@Parcelize
data class Audiobooks(

    @SerializedName("audiobooks")
    val audiobooks: Array<Audiobook>,
) : Parcelable
