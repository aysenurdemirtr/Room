package com.example.room.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.room.R
import com.example.room.ui.hilt.HiltActivity
import com.example.room.ui.room.RoomActivity


class MainActivity : AppCompatActivity() {

    private lateinit var roomBtn: Button
    private lateinit var hiltBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // findViewById işlemi burada, setContentView'den sonra yapılmalı
        roomBtn = findViewById(R.id.room_btn)
        hiltBtn = findViewById(R.id.hilt_btn)

        roomBtn.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }

        hiltBtn.setOnClickListener {
            val intent = Intent(this, HiltActivity::class.java)
            startActivity(intent)
        }
    }
}
