package com.example.hiltpractice.ui.screens

import android.media.AudioManager
import android.media.ToneGenerator
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hiltpractice.transitMoors
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@Composable
fun SecondScreen(text: String) {

    var toneGen = remember { ToneGenerator(AudioManager.STREAM_MUSIC, 100) }
    val coroutineScope = rememberCoroutineScope()
    var job by  remember { mutableStateOf<Job?>(null) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Text("Second Activity", fontSize = 20.sp)
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Text("\"$text\"", fontSize = 18.sp, color = Color.DarkGray)
//
//            Spacer(Modifier.height(40.dp))

            Button(
                onClick = {
                    if (job?.isActive != true) {
                        job = coroutineScope.launch {
                            transitMoors(toneGen)
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Green),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp)
            ) {
                Text("Make sound", color = Color.DarkGray)
            }

            Spacer(Modifier.height(40.dp))

            Button(
                onClick = {
                    job?.cancel()
                    toneGen.stopTone()
                },
                colors = ButtonDefaults.buttonColors(Color.Yellow),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp)
            ) {
                Text("Stop sound", color = Color.DarkGray)
            }

            Spacer(Modifier.height(40.dp))

            ElevatedButton(
                onClick = {
                    job?.cancel()
                    toneGen.release()
                },
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) {
                Text("Release ToneGenerator")
            }
        }
    }
}