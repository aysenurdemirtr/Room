package com.example.room.data.entitys.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlbum(album: Album)

    @Query("SELECT * FROM album_table")
    fun getAllAlbum(): LiveData<List<Album>>

    @Query("DELETE FROM album_table")
    suspend fun deleteAllAlbum()
}
