package com.example.rickandmorty.presentation.ui.fragment.detailCharacter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repo: RickAndMortyRepository
) : ViewModel(){

    var liveData: LiveData<com.example.rickandmorty.data.model.characterModel.Result> = MutableLiveData()

    fun getDetail(id: String) {
        liveData = repo.getDetail(id)
    }
}