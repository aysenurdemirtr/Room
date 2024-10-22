package com.example.room.data.models.album

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums(): Response<List<AlbumItem>>

    // suspend fun getAlbums(): Response<List<AlbumItem>>
    // bu şekilde tanımlayıp hiç Albums sınıfına ihtiyaç duymayabilirim.
    // ancak daha temiz ve anlaşılır kod yapısı için kendi sınıfımı oluşturuyorum.
}