package com.example.rickandmorty.data.model.episodeCharacter

data class EpisodeResponse(
    val info: Info,
    val results: List<EpisodeResponseItem>
)