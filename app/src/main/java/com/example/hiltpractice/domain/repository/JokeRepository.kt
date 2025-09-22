package com.example.hiltpractice.domain.repository

import com.example.hiltpractice.data.model.JokeItem

interface JokeRepository {
    suspend fun getJoke(): Result<JokeItem>
}