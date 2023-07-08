package com.example.rickandmorty.data.service

import com.example.rickandmorty.data.model.characterModel.MainResponse
import com.example.rickandmorty.data.model.episodeCharacter.EpisodeResponseItem
import com.example.rickandmorty.data.model.locationCharacter.LocationsResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getCharacters(
        @Query("page")page: Int? = 1
    ) : retrofit2.Call<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>>

    @GET("character/{id}")
    fun getDetailCharacter(
        @Path("id") id: String,
    ): Call<com.example.rickandmorty.data.model.characterModel.Result>

    @GET("location")
    fun getLocation(
        @Query("page") page :Int? = 1
    ): Call<MainResponse<LocationsResponseItem>>

    @GET("episode")
    fun getEpisode(
        @Query("page") page: Int? = 1
    ): Call<MainResponse<EpisodeResponseItem>>

}