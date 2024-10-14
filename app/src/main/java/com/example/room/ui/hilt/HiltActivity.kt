package com.example.room.ui.hilt

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.room.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    private val hiltViewModel : HiltViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hilt_activity)

        hiltViewModel.startTest()

    }

}