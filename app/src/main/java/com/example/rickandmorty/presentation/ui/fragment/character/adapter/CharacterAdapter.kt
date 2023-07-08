package com.example.rickandmorty.presentation.ui.fragment.character.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rick_morty.presentation.ui.fragment.character.adapter.loadImage

import com.example.rickandmorty.databinding.ItemMovieBinding

class CharacterAdapter(
    private val click : (id: Int) -> Unit,
    private val onLongClick: (model: com.example.rickandmorty.data.model.characterModel.Result) -> Unit
) : Adapter<CharacterAdapter.AdapterViewHolder>() {
    private var list: ArrayList<com.example.rickandmorty.data.model.characterModel.Result> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: ArrayList<com.example.rickandmorty.data.model.characterModel.Result> = arrayListOf()){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AdapterViewHolder(
        ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            click(position)
        }
        holder.itemView.setOnLongClickListener {
            holder.binding.linearLayout.alpha = 0.5f
            onLongClick(list[position])
            true
        }

    }

    override fun getItemCount() = list.size


    inner class AdapterViewHolder( val binding: ItemMovieBinding) : ViewHolder(binding.root) {

        fun onBind(result: com.example.rickandmorty.data.model.characterModel.Result) {
            result.imgUrl.let { binding.image.loadImage(it) }
            binding.txtName.text = result.nameCharacter
            binding.txtRassa.text = result.type
            binding.txtGender.text = result.gender
            binding.txtStatus.text = result.statusLife
        }
    }
}




