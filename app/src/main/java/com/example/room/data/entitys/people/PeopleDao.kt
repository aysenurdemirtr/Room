package com.example.room.data.entitys.people

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPeople(people: People)

    @Query("SELECT * FROM people_table WHERE name = :name AND surname = :surname LIMIT 1")
    suspend fun getPersonByName(name: String, surname: String): People?

    @Query("DELETE FROM people_table")
    suspend fun deleteAllPeople()

    @Query("SELECT * FROM people_table")
    fun getAllPeople(): LiveData<List<People>>
}
