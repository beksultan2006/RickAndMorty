package com.example.rickandmorty.presentation.ui.fragment.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
  private val repository: LocalRepository
): ViewModel(){

    var liveData: LiveData<List<com.example.rickandmorty.data.model.characterModel.Result>> = MutableLiveData()

    fun getFavoriteCharacter() {
        liveData = repository.getFavoriteCharacters()
    }
}