package com.example.rickandmorty.presentation.ui.fragment.episodeCharacter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.characterModel.MainResponse
import com.example.rickandmorty.data.model.episodeCharacter.EpisodeResponseItem
import com.example.rickandmorty.data.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val repo: RickAndMortyRepository
) : ViewModel() {

    var liveData : LiveData<MainResponse<EpisodeResponseItem>> = MutableLiveData()

    fun getEpisodes() {
        liveData = repo.getEpisodes()
    }

}