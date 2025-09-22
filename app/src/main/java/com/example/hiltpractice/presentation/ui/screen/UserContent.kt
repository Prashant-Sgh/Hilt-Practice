package com.example.hiltpractice.presentation.ui.screen

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hiltpractice.data.model.JokeItem

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserContent(
) {
        val jokeItem = JokeItem(
        punchline = "Some random joke will come here.",
        setup = "And the setup for this joke will be visible here."
       )

    var doShow by remember { mutableStateOf(false) }
    var count by remember {mutableStateOf(0)}

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
                Text("$count", fontSize = 20.sp)

                Text(jokeItem.punchline, fontSize = 20.sp)

                if (doShow) {
                    Spacer(Modifier.height(50.dp))
                    Text(jokeItem.setup, fontSize = 18.sp, color = Color.DarkGray)
                } else {
                    Spacer(Modifier.height(50.dp))

                    Button(onClick = {}) {
                        Text("Tell")
                    }
                }

                Spacer(Modifier.height(200.dp))

                Button(
                    onClick = {
                        doShow = !doShow
                        count++
                        Log.d("PrintX", "Button Pressed - $count, AND doSHow - $doShow")
                    }
                ) {
                    Text("Toggle show")
                }


            }
        }
    })

}