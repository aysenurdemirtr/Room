package com.example.room.data.entitys.person

import androidx.room.Entity
import androidx.room.PrimaryKey


// This class represents a table within the database.

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val age : Int,
    val sex : Boolean
)