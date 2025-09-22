package com.example.hiltpractice.presentation.ui.screen

import com.example.hiltpractice.data.model.JokeItem
import javax.inject.Inject

data class UserContentUiState @Inject constructor(
    val isLoading: Boolean,
    val jokeItem: JokeItem,
    val hasError: Boolean
)