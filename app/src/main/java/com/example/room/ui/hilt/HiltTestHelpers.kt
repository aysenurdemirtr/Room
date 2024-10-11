package com.example.room.ui.hilt

import android.util.Log
import javax.inject.Inject

class HiltTestHelpers @Inject constructor() {
    fun test(){
        Log.d("Test", "Test")
    }
}