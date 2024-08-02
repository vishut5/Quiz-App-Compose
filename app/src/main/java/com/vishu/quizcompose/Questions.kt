package com.vishu.quizcompose

data class Questions(
    val text: String,
    val imageResId: Int,
    val options: List<String>,
    val correctOptionIndex: Int
)

val questions = listOf(
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_india,
        options = listOf("USA", "France", "India", "Japan"),
        correctOptionIndex = 2
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_fiji,
        options = listOf("Australia", "Belgium", "Brazil", "Fiji"),
        correctOptionIndex = 3
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_kuwait,
        options = listOf("Kuwait", "Germany", "New Zealand", "India"),
        correctOptionIndex = 0
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_australia,
        options = listOf("Germany", "Spain", "France", "Austaralia"),
        correctOptionIndex = 3
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_brazil,
        options = listOf("Brazil", "India", "America", "Argentina"),
        correctOptionIndex = 0
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_germany,
        options = listOf("New Zealand", "Germany", "Austraila", "Brazil"),
        correctOptionIndex = 1
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_belgium,
        options = listOf("Belgium", "India", "Thailand", "Malaysia"),
        correctOptionIndex = 0
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_denmark,
        options = listOf("Germany", "Phillipines", "Denmark", "Turkey"),
        correctOptionIndex = 2
    ),
    Questions(
        text = "What country does this flag belong to?",
        imageResId = R.drawable.ic_flag_of_argentina,
        options = listOf("India", "Argentina", "Denmark", "Austraila"),
        correctOptionIndex = 1
    )
)
