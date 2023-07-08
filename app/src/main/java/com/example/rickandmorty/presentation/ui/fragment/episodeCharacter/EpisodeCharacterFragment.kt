package com.example.rickandmorty.presentation.ui.fragment.episodeCharacter

import androidx.fragment.app.viewModels
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.data.model.episodeCharacter.EpisodeResponseItem
import com.example.rickandmorty.databinding.FragmentEpisodeCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeCharacterFragment :
    BaseFragment<FragmentEpisodeCharacterBinding>(FragmentEpisodeCharacterBinding::inflate) {

    private val viewModel: EpisodesViewModel by viewModels()
    private val adapter: EpisodeAdapter by lazy {
        EpisodeAdapter()
    }

    override fun setupUI() {
        viewModel.getEpisodes()
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setData(it.results as ArrayList<EpisodeResponseItem>)
            binding.rvEpisode.adapter = adapter
        }
    }
}