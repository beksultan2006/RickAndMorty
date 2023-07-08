package com.example.rickandmorty.presentation.ui.fragment.main


import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun setupUI() {
        binding.vpItem.adapter = MainAdapter(this)

        val list = listOf(
            "Characters",
            "Location",
            "Episodes"
        )

        TabLayoutMediator(binding.tabLayout, binding.vpItem) { tab, pos ->
            tab.text = list[pos]
        }.attach()

    }

    override fun setupObServer() {

    }
}