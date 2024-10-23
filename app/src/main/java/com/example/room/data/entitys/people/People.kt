package com.example.room.data.entitys.people

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.annotations.JsonAdapter
import java.lang.reflect.Type


@Entity(tableName = "people_table")
data class People(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    val name : String,
    val surname : String,
    val age : Int? = null,
    val gender : Gender
) {

    @JsonAdapter(Gender.GenderSerializer::class)
    enum class Gender(val serverName : String, val screenName : String, val id : Int) {
        ADAM("MALE", "BEY", 1),
        KADIN("FEMALE", "BAYAN", 2);


        class GenderSerializer : JsonSerializer<Gender>, JsonDeserializer<Gender> {

            override fun deserialize(json : JsonElement?, typeOfT : Type?, context : JsonDeserializationContext?) : Gender {

                return Gender.values().find { it.serverName == json?.asString }!!
            }

            override fun serialize(src : Gender?, typeOfSrc : Type?, context : JsonSerializationContext?) : JsonElement {

                return JsonPrimitive(src!!.serverName)
            }
        }

        class Converters {

            @TypeConverter
            fun fromGender(value : Gender) : Int {

                return value.id
            }

            @TypeConverter
            fun toGender(value : Int) : Gender {
                return Gender.values().find { it.id == value }!!
            }
        }
    }
}
