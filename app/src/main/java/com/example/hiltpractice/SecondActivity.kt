package com.example.hiltpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hiltpractice.ui.theme.HiltPracticeTheme
import android.media.AudioManager
import android.media.ToneGenerator
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay

class SecondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = intent.getStringExtra("AcDc")?: "Text not fetched"
        setContent {
            HiltPracticeTheme {
                SecondScreen(text)
            }
        }
    }
}

suspend fun transitMoors(toneGen: ToneGenerator) {
    toneGen.startTone(ToneGenerator.TONE_DTMF_0, 800)
    delay(200)
    toneGen.startTone(ToneGenerator.TONE_DTMF_0, 400)
    delay(200)
    toneGen.startTone(ToneGenerator.TONE_DTMF_0, 400)
    delay(200)
    toneGen.startTone(ToneGenerator.TONE_DTMF_0, 200)
    delay(200)
    toneGen.startTone(ToneGenerator.TONE_DTMF_0, 200)
    delay(200)
    toneGen.startTone(ToneGenerator.TONE_DTMF_0,100)
}

@Composable
fun SecondScreen(text: String) {

    var toneGen = ToneGenerator(AudioManager.STREAM_MUSIC, 100)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Second Activity", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Text("\"$text\"", fontSize = 18.sp, color = Color.DarkGray)

            Spacer(Modifier.height(40.dp))

            Button(
                onClick = {

                    //TODO call a suspend function for tones when button clicked.
//                    toneGen.startTone(ToneGenerator.TONE_DTMF_0, 3000)
//                    rememberCoroutineScope {
//                        transitMoors(toneGen)
//                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Green),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp)
            ) {
                Text("Make sound", color = Color.DarkGray)
            }

            Spacer(Modifier.height(40.dp))

            Button(
                onClick = {
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
                    toneGen.release()
                          },
                colors = ButtonDefaults.buttonColors(Color.Red),
//                elevation = ButtonDefaults.buttonElevation(defaultElevation = 7.dp)
            ) {
                Text("Release ToneGenerator")
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun Preview() {
//    SecondScreen("Highway to hell")
//}