package com.example.hiltpractice.models

import javax.inject.Inject

data class UIstate @Inject constructor(
    val isLoading: Boolean,
    val jokeItem: JokeItem,
    val hasError: Boolean
)