package nl.tommert.spotify.webapi.network

import nl.tommert.spotify.webapi.model.request.AuthorizationRequest
import nl.tommert.spotify.webapi.model.request.RefreshRequest
import nl.tommert.spotify.webapi.model.response.Authorization
import nl.tommert.spotify.webapi.model.response.Refresh
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface AuthorizationService {

    @FormUrlEncoded
    @POST("token")
    suspend fun requestAccessToken(
        @Field("code") code: String,
        @Field("redirect_uri") redirectUri: String,
        @Header("Authentication") authentication: String,
        @Field("grant_type") grantType: String = "authorization_code",
    ): Authorization

    @POST("")
    suspend fun requestRefreshedToken(
        @Field("refresh_token") refreshToken: String,
        @Field("client_id") clientId: String,
        @Field("grant_type") grantType: String = "refresh_token",
    ): Refresh
}
