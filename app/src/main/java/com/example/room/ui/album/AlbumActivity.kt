package com.example.room.ui.album

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumActivity : AppCompatActivity() {

    private lateinit var albumViewModel: AlbumViewModel
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.albumRecyclerView)
        val cleanButton = findViewById<Button>(R.id.clean_btn)
        val dataButton = findViewById<Button>(R.id.show_btn)

        dataButton.setOnClickListener {
            albumViewModel.fetchAndInsertAlbum()
        }

        cleanButton.setOnClickListener {
            albumViewModel.deleteAllAlbum()
        }

        albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)

        albumAdapter = AlbumAdapter(listOf())
        recyclerView.adapter = albumAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        albumViewModel.getAllAlbum.observe(this, Observer { albumList ->
            albumAdapter.setAlbum(albumList)
        })

        albumViewModel.getAllAlbum.observe(this, Observer { albumList ->
            Log.d("AlbumActivity", "Album list size: ${albumList.size}")
            albumAdapter.setAlbum(albumList)
        })

        albumViewModel.fetchAndInsertAlbum()

    }

}