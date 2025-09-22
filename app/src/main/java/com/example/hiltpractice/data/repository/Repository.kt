package com.example.hiltpractice.data.repository

import com.example.hiltpractice.data.model.JokeItem
import com.example.hiltpractice.data.network.JokeApiService
import jakarta.inject.Inject


class Repository @Inject constructor(
    private val apiService: JokeApiService
) {
    suspend fun getJoke(): Result<JokeItem> {
        return runCatching {
            val response = apiService.fetchJoke()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                body
            } else {
                throw Exception("Something went wrong")
            }
        }
    }
}