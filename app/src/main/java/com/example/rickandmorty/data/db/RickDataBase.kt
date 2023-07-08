package com.example.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.example.rickandmorty.data.model.characterModel.Result:: class], version = 2)
abstract class RickDataBase: RoomDatabase() {
    abstract fun getDao(): RickDao
}