package com.example.hiltpractice.ui.screens

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.navigation.NavController
import com.example.hiltpractice.SecondActivity
import com.example.hiltpractice.domain.useCase.MoorseConvert

@Composable
fun MainScreen (
    modifier: Modifier = Modifier,
//    context: Context,
//    navController: NavController
) {

    var inputText by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("waiting") }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(message, fontSize = 25.sp)
            Spacer(Modifier.height(50.dp))
            TextField(
                value = inputText,
                onValueChange = {inputText = it},
                label = {Text("Enter your messsage")}
            )
            Spacer(Modifier.height(50.dp))

            Button(onClick = {
                message = MoorseConvert(inputText)
                Log.d("morse", "The message is: ${MoorseConvert(inputText)}")
            }) { Text("Convert") }

            Spacer(Modifier.height(50.dp))

//            Text(
//                text = "This is the first screen from Main Activity",
//            )
//            Spacer(Modifier.height(10.dp))

//            Button(
//                onClick = {
//
////                    navController.navigate("secondScreen")
//
////                    val intent = Intent(context, SecondActivity::class.java)
////                    intent.putExtra("AcDc", "Highway to hell")
////                    context.startActivity(intent)
//
////                    val intent = Intent(Intent.ACTION_VIEW)
////                    intent.data = "https://github.com/Prashant-Sgh".toUri()
////                    context.startActivity(intent)
//                }
//            ) {
//                Text("Click me")
//            }
//            Spacer(Modifier.height(10.dp))
//            Text(
//                text = "*This button should shift you to second screen",
//                fontSize = 14.sp,
//                color = Color.DarkGray
//            )
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun hdk() {
//    MainScreen()
//}