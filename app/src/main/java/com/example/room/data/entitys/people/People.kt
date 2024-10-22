package com.example.room.data.entitys.people

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter


@Entity(tableName = "people_table")
data class People(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // id alanı eklendi
    val name: String,
    val surname: String,
    val age: Int?,
    val gender: Gender
)

enum class Gender {
    MALE, FEMALE
}

class Converters {

    @TypeConverter
    fun fromGender(value: Gender): String {
        return value.name
    }

    @TypeConverter
    fun toGender(value: String): Gender {
        return Gender.valueOf(value)
    }
}

