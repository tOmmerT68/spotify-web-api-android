package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class ItemsUIModel<out T>(
    val href: String?,
    val items: List<T>,
    val limit: Int?,
    val next: String?,
    val offset: Int?,
    val previous: String?,
    val total: Int?,
) : SpotifyUIModel
