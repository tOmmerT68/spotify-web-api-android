package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.response.Album
import nl.tommert.spotify.webapi.model.Artist
import nl.tommert.spotify.webapi.model.Items
import nl.tommert.spotify.webapi.model.response.Track
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtistService : SpotifyService {

    /**
     * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
     * @param id The Spotify ID of the artist.
     */
    @GET("$ARTISTS/{id}")
    suspend fun getArtist(
        @Path("id") id: String,
    ): Artist

    /**
     * Get Spotify catalog information for several artists based on their Spotify IDs.
     * @param ids A comma-separated list of the Spotify IDs for the artists. Maximum: 50 IDs.
     */
    @GET(ARTISTS)
    suspend fun getArtists(
        @Query("ids") ids: String,
    ): Array<Artist>

    /**
     * Get Spotify catalog information about an artist's albums.
     * @param id The Spotify ID of the artist.
     * @param includeGroups A comma-separated list of keywords that will be used to filter the response. If not supplied, all album types will be returned.
     * Valid values are:
     * - album
     * - single
     * - appears_on
     * - compilation
     * For example: include_groups=album,single.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("$ARTISTS/{id}/albums")
    suspend fun getArtistsAlbums(
        @Path("id") id: String,
        @Query("include_groups") includeGroups: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("market") market: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Album>

    /**
     * Get Spotify catalog information about an artist's top tracks by country.
     * @param id The Spotify ID of the artist.
     * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @GET("$ARTISTS/{id}/top-tracks")
    suspend fun getArtistsTopTracks(
        @Path("id") id: String,
        @Query("market") market: String? = null,
    ): Array<Track>

    /**
     * Get Spotify catalog information about artists similar to a given artist. Similarity is based on analysis of the Spotify community's listening history.
     * @param id The Spotify ID of the artist.
     */
    @GET("$ARTISTS/{id}/related-artists")
    suspend fun getArtistsRelatedArtists(
        @Path("id") id: String,
    ): Array<Artist>

    companion object {

        const val ARTISTS = "artists"
    }
}
