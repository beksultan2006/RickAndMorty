package com.example.rickandmorty.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.model.characterModel.MainResponse
import com.example.rickandmorty.data.model.episodeCharacter.EpisodeResponseItem
import com.example.rickandmorty.data.model.locationCharacter.LocationsResponseItem
import com.example.rickandmorty.data.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(private val apiService: ApiService) {

    val liveData = MutableLiveData<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>>()
    fun getCharacter(page: Int): LiveData<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>> {
        apiService.getCharacters(page = page).enqueue(object : retrofit2.Callback<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>> {
            override fun onResponse(
                call: Call<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>>,
                response: Response<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("ololo", it) }
            }

        })
        return liveData
    }


    fun getDetail(id: String): LiveData<com.example.rickandmorty.data.model.characterModel.Result> {
        val liveData = MutableLiveData<com.example.rickandmorty.data.model.characterModel.Result>()
        apiService.getDetailCharacter(id).enqueue(object : Callback<com.example.rickandmorty.data.model.characterModel.Result> {
            override fun onResponse(
                call: Call<com.example.rickandmorty.data.model.characterModel.Result>,
                response: Response<com.example.rickandmorty.data.model.characterModel.Result>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<com.example.rickandmorty.data.model.characterModel.Result>, t: Throwable) {
                t.localizedMessage?.let { Log.e("ololo", it) }
            }

        })
        return liveData
    }


    fun getEpisodes(): LiveData<MainResponse<EpisodeResponseItem>> {
        val liveData = MutableLiveData<MainResponse<EpisodeResponseItem>>()
        apiService.getEpisode().enqueue(object: Callback<MainResponse<EpisodeResponseItem>>{
            override fun onResponse(
                call: Call<MainResponse<EpisodeResponseItem>>,
                response: Response<MainResponse<EpisodeResponseItem>>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<EpisodeResponseItem>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("ololo", it) }
            }

        })
        return liveData
    }

    fun getLocations(): LiveData<MainResponse<LocationsResponseItem>>{
        val liveData = MutableLiveData<MainResponse<LocationsResponseItem>>()
        apiService.getLocation().enqueue(object : Callback<MainResponse<LocationsResponseItem>>{
            override fun onResponse(
                call: Call<MainResponse<LocationsResponseItem>>,
                response: Response<MainResponse<LocationsResponseItem>>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<LocationsResponseItem>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("ololo", it) }
            }
        })
        return liveData
    }
}