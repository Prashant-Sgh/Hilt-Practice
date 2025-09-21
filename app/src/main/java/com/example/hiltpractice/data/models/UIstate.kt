package com.example.hiltpractice.data.models

import javax.inject.Inject

data class UIstate @Inject constructor(
    val isLoading: Boolean,
    val jokeItem: JokeItem,
    val hasError: Boolean
)