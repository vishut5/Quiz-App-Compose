package com.vishu.quizcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun StartScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    val context = LocalContext.current

    val backgroundImage =
        painterResource(id = R.drawable.ic_bg) // replace with your actual background image

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Quiz App!",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Welcome",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Please enter your name.",
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                        label = { Text(text = "Name", color = Color.LightGray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            if (name.isBlank()) {
                                Toast.makeText(context, "Enter your name", Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                navController.navigate("quizScreen")
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                    ) {
                        Text(text = "START", color = Color.White)
                    }
                }
            }
        }
    }
}
