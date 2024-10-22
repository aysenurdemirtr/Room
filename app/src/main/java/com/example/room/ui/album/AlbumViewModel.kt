package com.example.room.ui.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.data.entitys.album.Album
import com.example.room.data.entitys.album.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val albumRepository: AlbumRepository
) : ViewModel() {

    val getAllAlbum: LiveData<List<Album>> = albumRepository.getAllAlbum

    fun fetchAndInsertAlbum() {
        viewModelScope.launch {
            albumRepository.fetchAndInsertAlbumFromApi()
        }
    }
}