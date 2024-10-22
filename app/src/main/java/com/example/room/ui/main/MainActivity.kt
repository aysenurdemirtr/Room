package com.example.room.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.room.R
import com.example.room.data.models.album.RetrofitInstance
import com.example.room.data.models.album.AlbumService
import com.example.room.ui.hilt.HiltActivity
import com.example.room.ui.people.PeopleActivity
import com.example.room.ui.album.AlbumActivity
import com.example.room.ui.room.RoomActivity
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var roomBtn: Button
    private lateinit var hiltBtn: Button
    private lateinit var retrofitBtn: Button
    private lateinit var peopleBtn: Button
//    private lateinit var albumService : AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

 //       albumService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)


        // findViewById işlemi burada, setContentView'den sonra yapılmalı
        roomBtn = findViewById(R.id.room_btn)
        hiltBtn = findViewById(R.id.hilt_btn)
        retrofitBtn = findViewById(R.id.retrofit_btn)
        peopleBtn = findViewById(R.id.people_btn)

        roomBtn.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }

        hiltBtn.setOnClickListener {
            val intent = Intent(this, HiltActivity::class.java)
            startActivity(intent)
        }

        retrofitBtn.setOnClickListener(){
            val intent = Intent(this, AlbumActivity::class.java)
            startActivity(intent)
        }
        peopleBtn.setOnClickListener(){
            val intent = Intent(this, PeopleActivity::class.java)
            startActivity(intent)
        }

//        // Retrofit çağrısını yapalım
//        lifecycleScope.launch {
//            fetchAlbums()
//        }
    }
//    private suspend fun fetchAlbums() {
//        try {
//            val response = albumService.getAlbums()
//            if (response.isSuccessful) {
//                val albums = response.body()
//                albums?.forEach {
//                    Log.d("Album", "Title: ${it.title}, UserId: ${it.userId}")
//                }
//            } else {
//                Log.e("Error", "Response not successful: ${response.code()}")
//            }
//        } catch (e: Exception) {
//            Log.e("Error", "Exception: ${e.message}")
//        }
//    }
}
