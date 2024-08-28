package com.unonomercy.core.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination

import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.wear.compose.material.ContentAlpha
import com.unonomercy.core.ui.navigation.BottomBarScreen
import com.unonomercy.core.ui.screens.*

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, BottomBarScreen.Home.route, modifier = modifier) {
        composable(BottomBarScreen.Home.route) { MainScreen() }
        composable(BottomBarScreen.Counter.route) { CounterView() }
        composable(BottomBarScreen.Quiz.route) { QuizScreen() }
        composable(BottomBarScreen.About.route) { AboutScreen() }
    }
}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Counter,
        BottomBarScreen.Quiz,
        BottomBarScreen.About
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddItem(screen, currentDestination, navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val colors = NavigationBarItemDefaults.colors(
        unselectedIconColor = LocalContentColor.current.copy(ContentAlpha.disabled),
        selectedIconColor = MaterialTheme.colorScheme.secondary
    )

    NavigationBarItem(
        label = { Text(screen.title) },
        icon = { Icon(painterResource(screen.icon), "navigation icon") },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        colors = colors,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
        