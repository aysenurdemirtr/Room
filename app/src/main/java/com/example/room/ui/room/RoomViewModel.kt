package com.example.room.ui.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.data.entitys.person.Person
import com.example.room.data.entitys.person.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// between repository and UI
@HiltViewModel
class RoomViewModel @Inject constructor(
    private val repository : PersonRepository
) : ViewModel(){

    val readAllData : LiveData<List<Person>> = repository.readAllData

    // Verileri listelemek için gözlemci
    fun getAllPersons(): LiveData<List<Person>> {
        return readAllData
    }

    fun updatePerson(person: Person) {
    //    testHelpers.test()
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePerson(person)
        }
    }

    fun addPerson(person: Person) {
        // Arka planda çalışır
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPerson(person)
        }
    }

    fun deleteLastNPersons(n: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteLastNPersons(n)
        }
    }
}
