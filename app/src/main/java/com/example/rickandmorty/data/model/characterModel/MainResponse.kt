package com.example.rickandmorty.data.model.characterModel

data class MainResponse<T>(
    val info: Info,
    val results: List<T>
)