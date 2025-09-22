package com.example.hiltpractice.data.model

data class JokeItem(
    var id: Int = 0,
    var punchline: String = "Punch line",
    var setup: String = "setup",
    var type: String = "type"
)