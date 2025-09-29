package com.example.hiltpractice.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hiltpractice.ui.screens.MainScreen
import com.example.hiltpractice.ui.screens.SecondScreen

@Composable
fun HomeScreen(modifier: Modifier) {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController, "mainScreen") {
        composable("mainScreen") { MainScreen(modifier) }
        composable("secondScreen"){ SecondScreen("Nothing text...") }
    }
}