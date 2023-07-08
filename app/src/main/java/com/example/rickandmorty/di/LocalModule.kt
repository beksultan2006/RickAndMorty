package com.example.rickandmorty.di

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.data.db.RickDao
import com.example.rickandmorty.data.db.RickDataBase
import com.example.rickandmorty.data.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            RickDataBase::class.java,
            "DB_NAME")
            .allowMainThreadQueries()
            .build()

    @Provides
    fun provideDao(db: RickDataBase) = db.getDao()

    @Provides
    fun provideLocalRepository(rickDao: RickDao)=
        LocalRepository(rickDao)

}
