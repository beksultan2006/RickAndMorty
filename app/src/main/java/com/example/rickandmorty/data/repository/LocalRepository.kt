package com.example.rickandmorty.data.repository

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.db.RickDao
import javax.inject.Inject

class LocalRepository @Inject constructor(private val rickDao: RickDao) {

    fun getFavoriteCharacters(): LiveData<List<com.example.rickandmorty.data.model.characterModel.Result>> {
        return rickDao.getAllCharacter()
    }
    fun addCharacter(result: com.example.rickandmorty.data.model.characterModel.Result){
        rickDao.addCharacter(result)
    }
}