package com.example.room.data.entitys.person

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


// data access object. it contains all the methods used for accessing the database.
//we are creating all necessary querys.
@Dao
interface PersonDao {
    //if there is another person same, we just ignore that.
    //
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPerson(person: Person)

    // it will show updated, current data list. Reading data.
    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<Person>>

    // anlık olmasını istemezsem suspend ile kullanıyorum.
    // @Query("SELECT * FROM person_table ORDER BY id ASC")
   // suspend fun readAllData2() : List<Person>

    @Update
    suspend fun updatePerson(person: Person)

    @Query("DELETE FROM person_table WHERE id IN (SELECT id FROM person_table ORDER BY id DESC LIMIT :n)")
    suspend fun deleteLastNPersons(n: Int)
}