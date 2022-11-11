package nl.tommert.spotify.webapi.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import nl.tommert.spotify.webapi.android.example.ExampleActivity
import nl.tommert.spotify.webapi.android.ui.theme.SpotifyWebAPIAndroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val accessToken = Uri.parse(intent?.data.toString().replace("#", "?")).getQueryParameter("access_token")
        setContent {
            SpotifyWebAPIAndroidTheme {
                if (accessToken == null) {
                    Button(onClick = ::authenticate) {
                        Text(text ="Login")
                    }
                } else {
                    Button(onClick = { start(accessToken) }) {
                        Text(text = "Start")
                    }
                }
            }
        }
    }

    private fun authenticate() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AUTH_URL)))
    }

    private fun start(accessToken: String) {
        startActivity(ExampleActivity.createIntent(this, accessToken))
    }

    companion object {

        private const val CLIENT_ID = "ac152ecc900a4947a66e4049aff9f5de"
        private const val REDIRECT_URI = "spotify://nl.tommert.webapi"
        private const val SCOPE = "user-read-email"
        const val AUTH_URL = "https://accounts.spotify.com/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=$SCOPE&response_type=token"
    }
}
