package com.vishu.quizcompose
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun QuizApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "quizAppScreen") {
        composable("quizAppScreen") {
            StartScreen(navController)
        }
        composable("quizScreen") {
            QuizScreen(navController)
        }
    }
}
