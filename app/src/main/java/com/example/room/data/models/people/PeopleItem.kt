package com.example.room.data.models.people

import com.example.room.data.entitys.people.People
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("error")
    val error : ApiError?,

    @SerializedName("data")
    val data : List<People>?
)

data class ApiError(
    @SerializedName("message")
    val message : String,

    @SerializedName("code")
    val code : Int
)