package com.example.room.data.entitys.album

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album_table")
data class Album (
    @PrimaryKey(autoGenerate = true)
    val recordId: Int? = null,
    val userId: Int,
    val id: Int,
    val title: String,
)