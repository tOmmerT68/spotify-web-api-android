package nl.tommert.spotify.webapi.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import nl.tommert.spotify.webapi.SpotifyApi
import nl.tommert.spotify.webapi.android.ui.theme.SpotifyWebAPIAndroidTheme
import retrofit2.HttpException

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var text = ""
        val accessToken = intent?.data?.getQueryParameter("access_token")
        lifecycleScope.launch() {
            val albumService = accessToken?.let { SpotifyApi().getAlbumService(it) }
            text = try {
                albumService?.getUserSavedAlbums().toString()
            } catch (exception: HttpException) {
                exception.code().toString()
            }
        }
        setContent {
            SpotifyWebAPIAndroidTheme {
                Button(onClick = ::authenticate) {
                    Text(text = "Login")
                }
                Text(text = text)
            }
        }
    }

    private fun authenticate() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AUTH_URL)))
    }

    companion object {

        private const val CLIENT_ID = "ac152ecc900a4947a66e4049aff9f5de"
        private const val REDIRECT_URI = "android://nl.tommert.webapi"
        private const val SCOPE = "user-read-email"
        const val AUTH_URL = "https://accounts.spotify.com/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=$SCOPE&response_type=token"
    }
}
