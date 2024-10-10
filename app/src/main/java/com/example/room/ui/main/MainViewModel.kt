package com.example.room.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.AppDatabase
import com.example.room.TestApplication
import com.example.room.TestHelpers
import com.example.room.data.entitys.person.Person
import com.example.room.data.entitys.person.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// between repository and UI
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val testHelpers: TestHelpers = TestHelpers()
    private val repository : PersonRepository

    val readAllData : LiveData<List<Person>>


    init {
        repository = PersonRepository((application as TestApplication).appDatabase.personDao())
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
