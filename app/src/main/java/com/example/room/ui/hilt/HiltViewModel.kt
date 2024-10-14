package com.example.room.ui.hilt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltViewModel @Inject constructor(
    private val hiltTestHelpers: HiltTestHelpers
): ViewModel(){
    fun startTest(){
        hiltTestHelpers.test()
    }
}