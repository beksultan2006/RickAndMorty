package com.example.rickandmorty.presentation.ui.fragment.detailCharacter

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.rick_morty.presentation.ui.fragment.character.adapter.loadImage
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.data.service.ApiService
import com.example.rickandmorty.databinding.FragmentDetailCharacterBinding
import com.example.rickandmorty.di.RetrofitModule
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCharacterFragment :
    BaseFragment<FragmentDetailCharacterBinding>(FragmentDetailCharacterBinding::inflate){

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[DetailViewModel::class.java]
    }
    lateinit var apiService : ApiService


    override fun setupUI() {
        if(arguments != null) {
            val id = arguments?.getInt("id").toString()

            viewModel.getDetail(id)
            apiService = RetrofitModule.provideRetrofit()
        }
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            it?.let { binding.img.loadImage(it.imgUrl) }
            binding.txtName.text = it?.nameCharacter
            when (it.gender){
                "Male"-> binding.txtGender.setTextColor(Color.BLUE)
                "Female"-> binding.txtGender.setTextColor(Color.parseColor("#DD5080"))
                "unknown" -> binding.txtGender.setTextColor(Color.GRAY)
            }

            when(it.statusLife){
                "Alive" -> binding.txtStatus.setTextColor(Color.GREEN)
                "Dead" -> binding.txtStatus.setTextColor(Color.RED)
                "unknown" -> binding.txtStatus.setTextColor(Color.GRAY)
            }
            binding.txtGender.text = it?.gender
            binding.txtRassa.text = it?.type
            binding.txtStatus.text = it?.statusLife
        }
    }
}