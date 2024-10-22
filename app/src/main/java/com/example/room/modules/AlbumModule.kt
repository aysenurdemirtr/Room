package com.example.room.modules

import android.content.Context
import androidx.room.Room
import com.example.room.AlbumDatabase
import com.example.room.data.entitys.album.AlbumDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlbumModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AlbumDatabase {
        return Room.databaseBuilder(
            context,
            AlbumDatabase::class.java,
            "album_database"
        ).build()
    }

    //bu modülde bunu yer vermeme gerek var mı? Zaten database içerisinde dao var.
    @Provides
    fun provideAlbumDao(database: AlbumDatabase): AlbumDao {
        return database.albumDao()
    }
}