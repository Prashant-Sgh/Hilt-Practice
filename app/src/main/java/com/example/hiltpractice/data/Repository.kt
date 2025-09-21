package com.example.hiltpractice.data

import com.example.hiltpractice.data.models.JokeItem
import com.example.hiltpractice.data.network.JokeApiService
import jakarta.inject.Inject
import kotlin.collections.isNullOrEmpty


class Repository @Inject constructor(
    private val apiService: JokeApiService
) {
    suspend fun getJoke(): Result<JokeItem> {
        return try {
            val response = apiService.fetchJoke()
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            }
            else {
                Result.failure(Exception("Something went wrong"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    }
}