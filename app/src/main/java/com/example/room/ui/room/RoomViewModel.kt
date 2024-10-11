package com.example.room.ui.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room.ui.hilt.HiltTestApplication
import com.example.room.ui.hilt.HiltTestHelpers
import com.example.room.data.entitys.person.Person
import com.example.room.data.entitys.person.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// between repository and UI
class RoomViewModel(application: Application) : AndroidViewModel(application) {

    private val hiltTestHelpers: HiltTestHelpers = HiltTestHelpers()
    private val repository : PersonRepository

    val readAllData : LiveData<List<Person>>


    init {
        repository = PersonRepository((application as HiltTestApplication).appDatabase.personDao())
        readAllData = repository.readAllData // Repository'den LiveData olarak veri çekiliyor
    }

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
