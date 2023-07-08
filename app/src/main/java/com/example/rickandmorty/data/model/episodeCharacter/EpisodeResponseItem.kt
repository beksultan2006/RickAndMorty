package com.example.rickandmorty.data.model.episodeCharacter

data class EpisodeResponseItem(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)