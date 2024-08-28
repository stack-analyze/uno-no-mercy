package com.unonomercy.core.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.unonomercy.core.R.drawable
import com.unonomercy.core.ui.components.BottomBar
import com.unonomercy.core.ui.components.BottomNavGraph

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Home: BottomBarScreen(
        "home", "Inicio", drawable.ic_rules
    )

    data object Counter: BottomBarScreen(
        "counter", "Contador", drawable.ic_counter
    )

    data object Quiz: BottomBarScreen(
    "quiz", "Quiz", drawable.ic_quiz
    )

    data object About: BottomBarScreen(
        "about", "Acerca de", drawable.ic_about
    )
}

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = { BottomBar(navController) }
    ) {innerPadding ->
        val navStyles = Modifier.padding(innerPadding)
        BottomNavGraph(navController, navStyles)
    }
}