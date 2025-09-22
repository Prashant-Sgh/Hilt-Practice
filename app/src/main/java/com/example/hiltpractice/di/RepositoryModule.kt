package com.example.hiltpractice.di

import com.example.hiltpractice.data.repository.JokeRepositoryImpl
import com.example.hiltpractice.data.repository.Repository
import com.example.hiltpractice.domain.repository.JokeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun getJoke(repository: JokeRepositoryImpl): JokeRepository
}