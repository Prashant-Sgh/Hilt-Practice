package com.example.hiltpractice.domain.useCase

import com.example.hiltpractice.data.localDataSource.MoorseCodeDataSource

fun MoorseConvert(string: String): String{
    val result = string.uppercase().map { MoorseCodeDataSource.morseCodeMap[it] ?: "*" }.joinToString(" ")
    return result
}