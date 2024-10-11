package com.example.room.ui.hilt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.room.data.entitys.person.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltViewModel @Inject constructor(
    private val hiltTestHelpers: HiltTestHelpers
): ViewModel(){
    fun executeTest(){
        hiltTestHelpers.test()
    }

}