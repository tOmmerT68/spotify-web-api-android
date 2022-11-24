package nl.tommert.spotify.webapi.android.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import nl.tommert.spotify.webapi.network.AlbumService
import nl.tommert.spotify.webapi.network.ArtistService
import nl.tommert.spotify.webapi.network.CategoryService
import nl.tommert.spotify.webapi.network.EpisodeService
import nl.tommert.spotify.webapi.network.GenreService
import nl.tommert.spotify.webapi.network.MarketService
import nl.tommert.spotify.webapi.network.PlayerService
import nl.tommert.spotify.webapi.network.PlaylistService
import nl.tommert.spotify.webapi.network.SearchService
import nl.tommert.spotify.webapi.network.ShowService
import nl.tommert.spotify.webapi.network.SpotifyService
import nl.tommert.spotify.webapi.network.TrackService
import nl.tommert.spotify.webapi.network.UserService

class ExampleViewModel : ViewModel() {

    private lateinit var spotifyService: SpotifyService

    private val _result = MutableStateFlow(Any())
    val result: StateFlow<Any> = _result

    fun setService(service: SpotifyService) {
        spotifyService = service
    }

    fun getAlbum() = viewModelScope.launch {
        _result.value = (spotifyService as AlbumService).getAlbum("6s84u2TUpR3wdUv4NgKA2j")
    }

    fun getArtist() = viewModelScope.launch {
        _result.value = (spotifyService as ArtistService).getArtist("06HL4z0CvFAxyc27GXpf02")
    }

    fun getCategory() = viewModelScope.launch {
        _result.value = (spotifyService as CategoryService).getBrowsingCategory("dinner")
    }

    fun getEpisode() = viewModelScope.launch {
        _result.value = (spotifyService as EpisodeService).getEpisode("4X1Urx9yBEbe2s2ozzIkxJ")
    }

    fun getGenreSeeds() = viewModelScope.launch {
        _result.value = (spotifyService as GenreService).getAvailableGenreSeeds()
    }

    fun getAvailableMarkets() = viewModelScope.launch {
        _result.value = (spotifyService as MarketService).getAvailableMarkets()
    }

    fun getPlaybackState() = viewModelScope.launch {
        _result.value = (spotifyService as PlayerService).getPlaybackState()
    }

    fun getPlaylist() = viewModelScope.launch {
        _result.value = (spotifyService as PlaylistService).getPlaylist("45pNABviQPKKiRhiHIGTse")
    }

    fun search() = viewModelScope.launch {
        _result.value = (spotifyService as SearchService).getSearch("Bastille", "artist,album,track")
    }

    fun getShow() = viewModelScope.launch {
        _result.value = (spotifyService as ShowService).getShow("6TXzjtMTEopiGjIsCfvv6W")
    }

    fun getTrack() = viewModelScope.launch {
        _result.value = (spotifyService as TrackService).getTrack("3uUuGVFu1V7jTQL60S1r8z")
    }

    fun getCurrentUsersProfile() = viewModelScope.launch {
        _result.value = (spotifyService as UserService).getCurrentUsersProfile()
    }
}
