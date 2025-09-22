package com.example.hiltpractice.data.network

import com.example.hiltpractice.data.model.JokeItem
import retrofit2.Response
import retrofit2.http.GET

interface JokeApiService {
    @GET("base/url")
    suspend fun fetchJoke(): Response<JokeItem>
}