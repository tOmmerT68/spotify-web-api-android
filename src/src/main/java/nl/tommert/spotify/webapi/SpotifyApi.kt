package nl.tommert.spotify.webapi

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import nl.tommert.spotify.webapi.model.AccessTokenNotSetException
import nl.tommert.spotify.webapi.network.AlbumService
import nl.tommert.spotify.webapi.network.ArtistService
import nl.tommert.spotify.webapi.network.AudiobookService
import nl.tommert.spotify.webapi.network.CategoryService
import nl.tommert.spotify.webapi.network.ChapterService
import nl.tommert.spotify.webapi.network.EpisodeService
import nl.tommert.spotify.webapi.network.GenreService
import nl.tommert.spotify.webapi.network.MarketService
import nl.tommert.spotify.webapi.network.PlayerService
import nl.tommert.spotify.webapi.network.PlaylistService
import nl.tommert.spotify.webapi.network.SearchService
import nl.tommert.spotify.webapi.network.ShowService
import nl.tommert.spotify.webapi.network.TrackService
import nl.tommert.spotify.webapi.network.UserService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpotifyApi {

    private lateinit var accessToken: String

    fun setAccessToken(accessToken: String) {
        this.accessToken = accessToken
    }

    fun getAlbumService(): AlbumService =
        provideRetrofit().create(AlbumService::class.java)

    fun getArtistService(): ArtistService =
        provideRetrofit().create(ArtistService::class.java)

    fun getAudiobookService(): AudiobookService =
        provideRetrofit().create(AudiobookService::class.java)

    fun getCategoryService(): CategoryService =
        provideRetrofit().create(CategoryService::class.java)

    fun getChapterService(): ChapterService =
        provideRetrofit().create(ChapterService::class.java)

    fun getEpisodeService(): EpisodeService =
        provideRetrofit().create(EpisodeService::class.java)

    fun getGenreService(): GenreService =
        provideRetrofit().create(GenreService::class.java)

    fun getMarketService(): MarketService =
        provideRetrofit().create(MarketService::class.java)

    fun getPlayerService(): PlayerService =
        provideRetrofit().create(PlayerService::class.java)

    fun getPlaylistService(): PlaylistService =
        provideRetrofit().create(PlaylistService::class.java)

    fun getSearchService(): SearchService =
        provideRetrofit().create(SearchService::class.java)

    fun getShowService(): ShowService =
        provideRetrofit().create(ShowService::class.java)

    fun getTrackService(): TrackService =
        provideRetrofit().create(TrackService::class.java)

    fun getUserService(): UserService =
        provideRetrofit().create(UserService::class.java)

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SPOTIFY_ENDPOINT)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .build()
    }

    private fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        if (!::accessToken.isInitialized) {
            throw AccessTokenNotSetException()
        }
        return OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header("Authorization", "Bearer $accessToken")
                        .build()
                )
            }.build()
    }

    companion object {

        const val SPOTIFY_ENDPOINT = "https://api.spotify.com/v1/"
    }
}
