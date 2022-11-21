package nl.tommert.spotify.webapi.model

class AccessTokenNotSetException : Throwable() {

    override val message: String
        get() = "Required access token has not been set. Use setAccessToken(token: String) to set the token."
}
