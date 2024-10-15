package com.example.room.data.entitys.person

import androidx.lifecycle.LiveData
import javax.inject.Inject

// a repository class abstracts access to multiple data sources.

// db'deki değişiklikleri kolay bir şekilde ayarlayabilirim.
// yönetimi kolaylaştırıyor. birden fazla tabloya erişmesini istediğimde bi satır kod ile değiştirebilirim.

class PersonRepository @Inject constructor(private val personDao : PersonDao) {

    val readAllData: LiveData<List<Person>> = personDao.readAllData()

    // we use suspend cause we will use coroutines later.
    suspend fun addPerson(person: Person){
        personDao.addPerson(person)
    }
    suspend fun updatePerson(person: Person){
        personDao.updatePerson(person)
    }
    // Son eklenen n kaydı silen fonksiyon
    suspend fun deleteLastNPersons(n: Int) {
        personDao.deleteLastNPersons(n)
    }
}