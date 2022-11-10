package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.Category
import nl.tommert.spotify.webapi.model.Items
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryService {

    /**
     * Get a list of categories used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
     * @param country A country: an ISO 3166-1 alpha-2 country code. Provide this parameter to ensure that the category exists for a particular country.
     * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     * @param locale The desired language, consisting of an ISO 639-1 language code and an ISO 3166-1 alpha-2 country code, joined by an underscore.
     * For example: es_MX, meaning "Spanish (Mexico)". Provide this parameter if you want the category strings returned in a particular language.
     * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @GET("browse/$CATEGORIES")
    suspend fun getSeveralBrowseCategories(
        @Query("country") country: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("locale") locale: String? = null,
        @Query("offset") offset: Int? = null,
    ): Items<Category>

    /**
     * Get a single category used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
     * @param id The Spotify category ID for the category.
     * @param country A country: an ISO 3166-1 alpha-2 country code. Provide this parameter to ensure that the category exists for a particular country.
     * @param locale The desired language, consisting of an ISO 639-1 language code and an ISO 3166-1 alpha-2 country code, joined by an underscore.
     * For example: es_MX, meaning "Spanish (Mexico)". Provide this parameter if you want the category strings returned in a particular language.
     */
    @GET("browse/$CATEGORIES/{id}")
    suspend fun getBrowsingCategory(
        @Path("id") id: String,
        @Query("country") country: String? = null,
        @Query("locale") locale: String? = null,
    ): Category

    companion object {

        const val CATEGORIES = "categories"
    }
}
