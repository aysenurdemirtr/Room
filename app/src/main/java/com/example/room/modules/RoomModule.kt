package com.example.room.modules

import android.content.Context
import androidx.room.Room
import com.example.room.AppDatabase
import com.example.room.data.entitys.album.AlbumDao
import com.example.room.data.entitys.people.PeopleDao
import com.example.room.data.entitys.person.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context : Context
    ) : AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "person_database"
        ).build()
    }

    @Provides
    fun providePersonDao(database : AppDatabase) : PersonDao = database.personDao()

    @Provides
    fun provideAlbumDao(database : AppDatabase) : AlbumDao = database.albumDao()

    @Provides
    fun providePeopleDao(database : AppDatabase) : PeopleDao = database.peopleDao()

}
