package com.example.room.ui.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.room.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hilt_activity)



    }

}