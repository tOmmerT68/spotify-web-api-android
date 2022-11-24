package nl.tommert.spotify.api.model.response

import nl.tommert.spotify.api.model.generic.SpotifyUIModel

data class CategoryUIModel(
    val href: String,
    val icons: List<ImageUIModel>,
    val id: String,
    val name: String,
) : SpotifyUIModel
