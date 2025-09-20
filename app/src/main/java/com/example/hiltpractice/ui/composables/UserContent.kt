package com.example.hiltpractice.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hiltpractice.models.JokeItem

@Composable
fun UserContent(jokeItem: JokeItem, doShow: Boolean) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(Modifier.height(40.dp))
            Text("Some random joke.", fontSize = 20.sp)
            Spacer(Modifier.height(20.dp))
            Text(jokeItem.punchline)

            if (doShow) {
                Spacer(Modifier.height(15.dp))
                Text(jokeItem.setup)
            }
            else {
                Spacer(Modifier.height(25.dp))

                Button(onClick = {}) {
                    Text("Tell" )
                }
            }



        }
    }
}