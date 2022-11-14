package nl.tommert.spotify.webapi.android.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import nl.tommert.spotify.webapi.SpotifyApi
import nl.tommert.spotify.webapi.android.ui.theme.SpotifyWebAPIAndroidTheme

enum class Type {
    ALBUM,
    ARTIST,
    AUDIOBOOK,
    CATEGORY,
    CHAPTER,
    EPISODE,
    GENRE,
    MARKET,
    PLAYER,
    PLAYLIST,
    SEARCH,
    SHOW,
    TRACK,
    USER,
}

class ExampleActivity : ComponentActivity() {

    private val viewModel: ExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val accessToken = intent?.getStringExtra(ACCESS_TOKEN)!!
        val type = intent?.getSerializableExtra(TYPE) as Type
        viewModel.setService(
            when (type) {
                Type.ALBUM -> SpotifyApi().getAlbumService(accessToken)
                Type.ARTIST -> SpotifyApi().getArtistService(accessToken)
                Type.AUDIOBOOK -> SpotifyApi().getAudiobookService(accessToken)
                Type.CATEGORY -> SpotifyApi().getCategoryService(accessToken)
                Type.CHAPTER -> SpotifyApi().getChapterService(accessToken)
                Type.EPISODE -> SpotifyApi().getEpisodeService(accessToken)
                Type.GENRE -> SpotifyApi().getGenreService(accessToken)
                Type.MARKET -> SpotifyApi().getMarketService(accessToken)
                Type.PLAYER -> SpotifyApi().getPlayerService(accessToken)
                Type.PLAYLIST -> SpotifyApi().getPlaylistService(accessToken)
                Type.SEARCH -> SpotifyApi().getSearchService(accessToken)
                Type.SHOW -> SpotifyApi().getShowService(accessToken)
                Type.TRACK -> SpotifyApi().getTrackService(accessToken)
                Type.USER -> SpotifyApi().getUserService(accessToken)
            }
        )
        setContent {
            SpotifyWebAPIAndroidTheme {
                val scrollState = rememberScrollState()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    val result = viewModel.result.collectAsState()
                    Text(text = result.value.toString())
                    when (type) {
                        Type.ALBUM -> AlbumScreen()
                        Type.ARTIST -> ArtistScreen()
                        Type.AUDIOBOOK -> AudiobookScreen()
                        Type.CATEGORY -> CategoryScreen()
                        Type.CHAPTER -> ChapterScreen()
                        Type.EPISODE -> EpisodeScreen()
                        Type.GENRE -> GenreScreen()
                        Type.MARKET -> MarketScreen()
                        Type.PLAYER -> PlayerScreen()
                        Type.PLAYLIST -> PlaylistScreen()
                        Type.SEARCH -> SearchScreen()
                        Type.SHOW -> ShowScreen()
                        Type.TRACK -> TrackScreen()
                        Type.USER -> UserScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun AlbumScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getAlbum) {
                Text(text = "Get album")
            }
        }
    }

    @Composable
    private fun ArtistScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getArtist) {
                Text(text = "Get artist")
            }
        }
    }

    @Composable
    private fun AudiobookScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = {  }) {
                Text(text = "Get audiobook")
            }
        }
    }

    @Composable
    private fun CategoryScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getCategory) {
                Text(text = "Get category")
            }
        }
    }

    @Composable
    private fun ChapterScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = {  }) {
                Text(text = "Get chapter")
            }
        }
    }

    @Composable
    private fun EpisodeScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getEpisode) {
                Text(text = "Get episode")
            }
        }
    }

    @Composable
    private fun GenreScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getGenreSeeds) {
                Text(text = "Get genre seeds")
            }
        }
    }

    @Composable
    private fun MarketScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getAvailableMarkets) {
                Text(text = "Get available markets")
            }
        }
    }

    @Composable
    private fun PlayerScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getPlaybackState) {
                Text(text = "Get playback state")
            }
        }
    }

    @Composable
    private fun PlaylistScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getPlaylist) {
                Text(text = "Get playlist")
            }
        }
    }

    @Composable
    private fun SearchScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::search) {
                Text(text = "Search")
            }
        }
    }

    @Composable
    private fun ShowScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getShow) {
                Text(text = "Get show")
            }
        }
    }

    @Composable
    private fun TrackScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getTrack) {
                Text(text = "Get track")
            }
        }
    }

    @Composable
    private fun UserScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Button(onClick = viewModel::getCurrentUsersProfile) {
                Text(text = "Get users' profile")
            }
        }
    }

    companion object {

        private const val ACCESS_TOKEN = "ACCESS_TOKEN"
        private const val TYPE = "TYPE"

        fun createIntent(context: Context, accessToken: String, type: Type): Intent {
            return Intent(context, ExampleActivity::class.java)
                .putExtra(ACCESS_TOKEN, accessToken)
                .putExtra(TYPE, type)
        }
    }
}
