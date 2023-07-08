package com.example.rickandmorty.presentation.ui.fragment.locationCharacter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.characterModel.MainResponse
import com.example.rickandmorty.data.model.locationCharacter.LocationsResponseItem
import com.example.rickandmorty.data.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: RickAndMortyRepository
): ViewModel(){
    var liveData : LiveData<MainResponse<LocationsResponseItem>> = MutableLiveData()

    fun getLocations(){
        liveData = repository.getLocations()
    }
}