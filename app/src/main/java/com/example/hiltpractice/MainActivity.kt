package com.example.hiltpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.hiltpractice.data.repository.JokeRepositoryImpl
import com.example.hiltpractice.domain.repository.JokeRepository
import com.example.hiltpractice.presentation.ui.screen.UserContent
import com.example.hiltpractice.presentation.ui.theme.HiltPracticeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var jokeRepository: JokeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HiltPracticeTheme {
                UserContent(jokeRepository)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(
            text = name,
            modifier = modifier
        )
    }
}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun UserContentComposable() {
//
//    val jokeItem = JokeItem(
//        punchline = "Some random joke will come here.",
//        setup = "And the setup for this joke will be visible here."
//    )
//
//    val doShow: Boolean = true
//    HiltPracticeTheme {
//        UserContent(jokeItem, doShow)
//    }
//}