package nl.tommert.spotify.webapi.android.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import nl.tommert.spotify.webapi.android.ui.theme.SpotifyWebAPIAndroidTheme

class ExampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val accessToken = intent?.getStringExtra(ACCESS_TOKEN)
        setContent {
            SpotifyWebAPIAndroidTheme {
                Text(text = accessToken.toString())
            }
        }
    }

    companion object {

        private const val ACCESS_TOKEN = "ACCESS_TOKEN"

        fun createIntent(context: Context, accessToken: String): Intent {
            return Intent(context, ExampleActivity::class.java)
                .putExtra(ACCESS_TOKEN, accessToken)
        }
    }
}
