package com.example.room.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.data.entitys.people.PeopleRepository
import com.example.room.data.models.people.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository : PeopleRepository
) : ViewModel() {

    private val _apiResponseResultLiveData = MutableLiveData<ApiResponse>()
    val apiResponseResultLiveData : LiveData<ApiResponse>
        get() = _apiResponseResultLiveData

    val peopleDatabaseLiveData = repository.getAllPeople


    // API'den verileri alıp veritabanına ekle
    fun fetchAndInsertPeople(errorClicked : Boolean = false) {


        viewModelScope.launch {

            deleteAllPeople()

            repository.fetchAndInsertPeopleFromApi(errorClicked, _apiResponseResultLiveData)
        }
    }

    // Veritabanındaki tüm kayıtları sil
    fun deleteAllPeople() {
        viewModelScope.launch {
            repository.deleteAllPeople()
        }
    }
}
