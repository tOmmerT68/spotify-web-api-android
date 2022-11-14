package nl.tommert.spotify.webapi

import com.google.gson.Gson
import com.google.gson.GsonBuilder
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

    fun getAlbumService(accessToken: String): AlbumService =
        provideRetrofit(accessToken).create(AlbumService::class.java)

    fun getArtistService(accessToken: String): ArtistService =
        provideRetrofit(accessToken).create(ArtistService::class.java)

    fun getAudiobookService(accessToken: String): AudiobookService =
        provideRetrofit(accessToken).create(AudiobookService::class.java)

    fun getCategoryService(accessToken: String): CategoryService =
        provideRetrofit(accessToken).create(CategoryService::class.java)

    fun getChapterService(accessToken: String): ChapterService =
        provideRetrofit(accessToken).create(ChapterService::class.java)

    fun getEpisodeService(accessToken: String): EpisodeService =
        provideRetrofit(accessToken).create(EpisodeService::class.java)

    fun getGenreService(accessToken: String): GenreService =
        provideRetrofit(accessToken).create(GenreService::class.java)

    fun getMarketService(accessToken: String): MarketService =
        provideRetrofit(accessToken).create(MarketService::class.java)

    fun getPlayerService(accessToken: String): PlayerService =
        provideRetrofit(accessToken).create(PlayerService::class.java)

    fun getPlaylistService(accessToken: String): PlaylistService =
        provideRetrofit(accessToken).create(PlaylistService::class.java)

    fun getSearchService(accessToken: String): SearchService =
        provideRetrofit(accessToken).create(SearchService::class.java)

    fun getShowService(accessToken: String): ShowService =
        provideRetrofit(accessToken).create(ShowService::class.java)

    fun getTrackService(accessToken: String): TrackService =
        provideRetrofit(accessToken).create(TrackService::class.java)

    fun getUserService(accessToken: String): UserService =
        provideRetrofit(accessToken).create(UserService::class.java)


    private fun provideRetrofit(accessToken: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SPOTIFY_ENDPOINT)
            .client(provideOkHttpClient(accessToken))
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .build()
    }

    private fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    private fun provideOkHttpClient(accessToken: String): OkHttpClient {
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
