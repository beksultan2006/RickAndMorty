package com.example.rickandmorty.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Insert

@Dao
interface RickDao {

    @Query("select * from result")
    fun getAllCharacter(): LiveData<List<com.example.rickandmorty.data.model.characterModel.Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(result:com.example.rickandmorty.data.model.characterModel.Result)
}