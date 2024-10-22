package com.example.room.modules

import com.example.room.data.models.album.AlbumService
import com.example.room.data.models.people.PeopleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideAlbumService(@Named("AlbumRetrofit") retrofit: Retrofit): AlbumService {
        return retrofit.create(AlbumService::class.java)
    }

    @Provides
    @Singleton
    fun providePeopleService(@Named("PeopleRetrofit") retrofit: Retrofit): PeopleService {
        return retrofit.create(PeopleService::class.java)
    }
}
