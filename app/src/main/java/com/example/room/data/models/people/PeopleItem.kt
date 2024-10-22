package com.example.room.data.models.people

import com.example.room.data.entitys.people.Gender
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("error")
    val error: ApiError?,

    @SerializedName("data")
    val data: List<PeopleItem>?
)

data class ApiError(
    @SerializedName("message")
    val message: String?,

    @SerializedName("code")
    val code: Int?
)

data class PeopleItem(
    @SerializedName("name")
    val name: String,

    @SerializedName("surname")
    val surname: String,

    @SerializedName("age")
    val age: Int?,

    @SerializedName("gender")
    val gender: Gender
)
