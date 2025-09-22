package com.example.hiltpractice.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hiltpractice.domain.repository.JokeRepository

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserContent(
    jokeRepository: JokeRepository
) {
//        val jokeItem by remember { mutableStateOf( JokeItem(
//        punchline = "Loading.......",
//        setup = "Loading........"
//       ))}

    var punchline by remember { mutableStateOf("Loading.......") }
    var setup by remember { mutableStateOf("loading.......") }

    LaunchedEffect(Unit) {
        val result  = jokeRepository.getJoke()
        result.onSuccess { body ->
            punchline = body.punchline
            setup = body.setup
//            jokeItem.setup = body.setup
        }.onFailure { exception ->
            punchline = exception.message?: "Oops! something went really wrong"
            setup = exception.message?: "XXXXXXXXXXXXXXXXX"
//            jokeItem.setup = exception.message?: "XXXXXXXXXXXXXX"
        }
    }



    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Random Joke")
                    }
                },
            )
        },

     content = {paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(100.dp))
                Text(punchline, fontSize = 20.sp)

                    Spacer(Modifier.height(50.dp))
                    Text(setup, fontSize = 18.sp, color = Color.DarkGray)
                    Spacer(Modifier.height(50.dp))

                    Button(onClick = {}) {
                        Text("Tell")
                    }

                Spacer(Modifier.height(200.dp))

            }
        }
    })

}