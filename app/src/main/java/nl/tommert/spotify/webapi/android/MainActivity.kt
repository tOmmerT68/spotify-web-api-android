package nl.tommert.spotify.webapi.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import nl.tommert.spotify.webapi.SpotifyApi
import nl.tommert.spotify.webapi.android.example.ExampleActivity
import nl.tommert.spotify.webapi.android.ui.theme.SpotifyWebAPIAndroidTheme
import nl.tommert.spotify.webapi.model.request.AuthorizationRequest
import retrofit2.HttpException
import java.nio.Buffer

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val code = intent?.data?.getQueryParameter("code")
        setContent {
            SpotifyWebAPIAndroidTheme {
                if (code == null) {
                    Button(onClick = ::authenticate) {
                        Text(text ="Login")
                    }
                } else {
                    Button(onClick = { start(code) }) {
                        Text(text = code.toString())
                    }
                }
            }
        }
    }

    private fun authenticate() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AUTH_URL)))
    }

    private fun start(code: String) {
        lifecycleScope.launch {
            try {
                val auth = SpotifyApi().getAuthorizationService(this@MainActivity)
                    .requestAccessToken(code, REDIRECT_URI, AUTH)
                startActivity(ExampleActivity.createIntent(this@MainActivity, auth.accessToken))
            } catch (exception: HttpException) {
                setContent { Text(text = exception.response().toString()) }
            }
        }
    }

    companion object {

        private fun get64BaseString(value: String): String {
            return Base64.encodeToString(value.toByteArray(),Base64.NO_WRAP)
        }

        private const val CLIENT_ID = "ac152ecc900a4947a66e4049aff9f5de"
        private const val CLIENT_SECRET = "4963e190b9334d7ba6593472285214c8"
        private const val AUTH = "Basic ${get64BaseString("$CLIENT_ID:$CLIENT_SECRET")}"
        private const val REDIRECT_URI = "spotify://nl.tommert.webapi"
        private const val SCOPE = "user-read-email"
        const val AUTH_URL = "https://accounts.spotify.com/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=$SCOPE&response_type=code"
    }
}
