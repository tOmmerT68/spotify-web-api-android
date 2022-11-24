package nl.tommert.spotify.webapi.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.tommert.spotify.webapi.android.example.ExampleActivity
import nl.tommert.spotify.webapi.android.example.Type
import nl.tommert.spotify.webapi.android.ui.theme.SpotifyWebAPIAndroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val accessToken = Uri.parse(intent?.data.toString().replace("#", "?")).getQueryParameter("access_token")
        setContent {
            SpotifyWebAPIAndroidTheme {
                if (accessToken == null) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(onClick = ::authenticate) {
                            Text(text ="Login")
                        }
                    }
                } else {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(onClick = { start(accessToken, Type.ALBUM) }) {
                            Text(text = "Album service")
                        }
                        Button(onClick = { start(accessToken, Type.ARTIST) }) {
                            Text(text = "Artist service")
                        }
                        Button(onClick = { start(accessToken, Type.AUDIOBOOK) }) {
                            Text(text = "Audiobook service")
                        }
                        Button(onClick = { start(accessToken, Type.CATEGORY) }) {
                            Text(text = "Category service")
                        }
                        Button(onClick = { start(accessToken, Type.CHAPTER) }) {
                            Text(text = "Chapter service")
                        }
                        Button(onClick = { start(accessToken, Type.EPISODE) }) {
                            Text(text = "Episode service")
                        }
                        Button(onClick = { start(accessToken, Type.GENRE) }) {
                            Text(text = "Genre service")
                        }
                        Button(onClick = { start(accessToken, Type.MARKET) }) {
                            Text(text = "Market service")
                        }
                        Button(onClick = { start(accessToken, Type.PLAYER) }) {
                            Text(text = "Player service")
                        }
                        Button(onClick = { start(accessToken, Type.PLAYLIST) }) {
                            Text(text = "Playlist service")
                        }
                        Button(onClick = { start(accessToken, Type.SEARCH) }) {
                            Text(text = "Search service")
                        }
                        Button(onClick = { start(accessToken, Type.SHOW) }) {
                            Text(text = "Show service")
                        }
                        Button(onClick = { start(accessToken, Type.TRACK) }) {
                            Text(text = "Track service")
                        }
                        Button(onClick = { start(accessToken, Type.USER) }) {
                            Text(text = "User service")
                        }
                    }
                }
            }
        }
    }

    private fun authenticate() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AUTH_URL)))
    }

    private fun start(accessToken: String, type: Type) {
        startActivity(ExampleActivity.createIntent(this, accessToken, type))
    }

    companion object {

        private const val CLIENT_ID = "ac152ecc900a4947a66e4049aff9f5de"
        private const val REDIRECT_URI = "spotify://nl.tommert.webapi"
        private const val SCOPE = "user-read-email ugc-image-upload user-read-playback-state user-modify-playback-state user-read-currently-playing app-remote-control streaming playlist-read-private playlist-read-collaborative playlist-modify-private playlist-modify-public user-follow-modify user-follow-read user-read-playback-position user-top-read user-read-recently-played user-library-modify user-library-read user-read-private"
        const val AUTH_URL = "https://accounts.spotify.com/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=$SCOPE&response_type=token"
    }
}
