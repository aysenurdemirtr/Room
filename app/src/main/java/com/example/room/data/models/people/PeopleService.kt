package com.example.room.data.models.people

import retrofit2.Response
import retrofit2.http.GET

interface PeopleService {

    @GET("/ardakaplan/a131e77c20d90f78d9b0d96894920290/raw/486cee6f923ff7445a7df7fcf744e5e394644222/for_aysenur")
    suspend fun getApiResponse() : Response<ApiResponse>
}