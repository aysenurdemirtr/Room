package com.example.room.data.models.people

import retrofit2.Response
import retrofit2.http.GET

interface PeopleService {
    @GET("/ardakaplan/a131e77c20d90f78d9b0d96894920290/raw/0b13e66f2776bfa410b737890bce2fbfe8a0cd1e/for_aysenur")
    suspend fun getApiResponse(): Response<ApiResponse>
}