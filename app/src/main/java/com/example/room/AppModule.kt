package com.example.room

import android.content.Context
import androidx.room.Room
import com.example.room.data.entitys.person.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "person_database"
        ).build()
    }

    @Provides
    fun providePersonDao(database: AppDatabase): PersonDao {
        return database.personDao()
    }

}
