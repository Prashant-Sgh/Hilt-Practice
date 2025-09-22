package com.example.hiltpractice.data.repository

import com.example.hiltpractice.data.model.JokeItem
import com.example.hiltpractice.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl
@Inject constructor(
    private val repository: Repository
): JokeRepository {
    override suspend fun getJoke(): Result<JokeItem> {
        return repository.getJoke()
    }
}