package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Chapter
import nl.tommert.spotify.webapi.model.response.Chapters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChapterService {

    /**
     * Get Spotify catalog information for a single chapter.
     * @param id The Spotify ID for the chapter.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("$CHAPTERS/{id}")
    suspend fun getChapter(
        @Path("id") id: String,
        @Query("market") market: String? = null,
    ): Chapter

    /**
     * Get Spotify catalog information for several chapters identified by their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET(CHAPTERS)
    suspend fun getSeveralChapters(
        @Query("ids") ids: String,
        @Query("market") market: String? = null,
    ): Chapters

    companion object {

        const val CHAPTERS = "chapters"
    }
}
