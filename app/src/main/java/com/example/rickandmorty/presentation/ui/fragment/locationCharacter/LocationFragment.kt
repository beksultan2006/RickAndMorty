package com.example.rickandmorty.presentation.ui.fragment.locationCharacter

import androidx.fragment.app.viewModels
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.data.model.locationCharacter.LocationsResponseItem
import com.example.rickandmorty.databinding.FragmentLacotionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLacotionBinding>(FragmentLacotionBinding::inflate) {

    private val viewModel: LocationViewModel by viewModels()
    private val adapter : LocationAdapter by lazy { LocationAdapter() }

    override fun setupUI() {
        viewModel.getLocations()
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setData(it.results as ArrayList<LocationsResponseItem>)
            binding.rvLocation.adapter = adapter
        }
    }
}