package com.example.hiltpractice.models

data class JokeItem(
    val id: Int = 0,
    val punchline: String = "Punch line",
    val setup: String = "setup",
    val type: String = "type"
)