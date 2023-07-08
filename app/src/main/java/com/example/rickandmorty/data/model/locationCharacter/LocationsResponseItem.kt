package com.example.rickandmorty.data.model.locationCharacter

data class LocationsResponseItem(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)