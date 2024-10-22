package com.example.room.data.entitys.album

import androidx.lifecycle.LiveData
import com.example.room.data.models.album.AlbumService
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private val albumDao: AlbumDao,
    private val albumService: AlbumService
) {
    val getAllAlbum: LiveData<List<Album>> = albumDao.getAllAlbum()

    suspend fun fetchAndInsertAlbumFromApi() {
        val response = albumService.getAlbums()
        response.body()?.let { albumItemList ->
            albumItemList.forEach { albumItem ->
                val album = Album(
                    userId = albumItem.userId,
                    id = albumItem.id,
                    title = albumItem.title,
                )
                albumDao.insertAlbum(album)
            }
        }
    }

    suspend fun deleteAllAlbum() {
        albumDao.deleteAllAlbum()
    }

}
