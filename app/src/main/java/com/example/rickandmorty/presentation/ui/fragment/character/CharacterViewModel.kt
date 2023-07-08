package com.example.rickandmorty.presentation.ui.fragment.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.characterModel.MainResponse
import com.example.rickandmorty.data.repository.LocalRepository
import com.example.rickandmorty.data.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: RickAndMortyRepository,
    private val localRepository: LocalRepository
):  ViewModel(){


    var liveData: LiveData<MainResponse<com.example.rickandmorty.data.model.characterModel.Result>> = MutableLiveData()


    fun getCharacter(page : Int) {
        liveData = repository.getCharacter(page)
    }

    fun addCharacter(result:com.example.rickandmorty.data.model.characterModel.Result){
        localRepository.addCharacter(result)
    }
}