package com.example.room.modules

import android.content.Context
import androidx.room.Room
import com.example.room.PeopleDatabase
import com.example.room.data.entitys.people.PeopleDao
import com.example.room.data.models.people.PeopleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PeopleModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): PeopleDatabase {
        return Room.databaseBuilder(
            context,
            PeopleDatabase::class.java,
            "people_database"
        ).build()
    }

    @Provides
    fun providePeopleDao(database: PeopleDatabase): PeopleDao {
        return database.peopleDao()
    }

}