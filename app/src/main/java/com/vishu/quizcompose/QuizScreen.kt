package com.vishu.quizcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var isAnswerChecked by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val question = questions[currentQuestionIndex]

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Quiz App",
                    color = Color.White,
                    style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF6200EE)
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = question.text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(2.dp))

            Image(
                painter = painterResource(id = question.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(220.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp, bottom = 8.dp), // Adjusted padding
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Row for progress and question number
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(
                    progress = (currentQuestionIndex + 1).toFloat() / questions.size,
                    modifier = Modifier
                        .weight(1f) // Make the progress bar take the remaining width
                        .height(8.dp)
                )
                Text(
                    text = "${currentQuestionIndex + 1}/${questions.size}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp) // Space between number and progress bar
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                question.options.forEachIndexed { index, option ->
                    val isSelected = selectedOptionIndex == index
                    val isCorrect = index == question.correctOptionIndex
                    val backgroundColor = when {
                        isAnswerChecked && isCorrect -> Color.Green
                        isAnswerChecked && isSelected && !isCorrect -> Color.Red
                        isSelected -> Color.LightGray
                        else -> Color.White
                    }
                    val borderColor = when {
                        isSelected -> Color.Blue
                        isAnswerChecked && isCorrect -> Color.Green
                        isAnswerChecked && isSelected && !isCorrect -> Color.Red
                        else -> Color.Gray
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp)
                            .border(2.dp, borderColor, RoundedCornerShape(8.dp)) // Border
                            .clickable { if (!isAnswerChecked) selectedOptionIndex = index }
                            .background(backgroundColor, RoundedCornerShape(8.dp)) // Background
                    ) {
                        Text(
                            text = option,
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp)) // Add space between options
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (!isAnswerChecked) {
                            isAnswerChecked = true
                            if (selectedOptionIndex != question.correctOptionIndex) {
                                Toast.makeText(context, "Try again!", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            if (currentQuestionIndex < questions.size - 1) {
                                currentQuestionIndex += 1
                                selectedOptionIndex = null
                                isAnswerChecked = false
                            } else {
                                Toast.makeText(context, "Quiz completed!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = if (currentQuestionIndex == questions.size - 1) "Check Score" else if (isAnswerChecked) "Next Question" else "Submit",
                        color = Color.White
                    )
                }
            }
        }
    }
}