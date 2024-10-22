package com.example.room.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.data.entitys.people.People
import com.example.room.data.entitys.people.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: PeopleRepository
) : ViewModel() {

    val allPeople: LiveData<List<People>> = repository.getAllPeople
    private val _errorData = MutableLiveData<Pair<Int,String>>()
    val errorData: LiveData<Pair<Int,String>> get() = _errorData

    // API'den verileri alıp veritabanına ekle
    fun fetchAndInsertPeople() {
        viewModelScope.launch {
            repository.fetchAndInsertPeopleFromApi(_errorData)
        }
    }

    // Veritabanındaki tüm kayıtları sil
    fun deleteAllPeople() {
        viewModelScope.launch {
            repository.deleteAllPeople()
        }
    }
}
