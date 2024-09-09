package com.example.menus


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { CustomScaffold(navController) }
        composable("build") { BuildScreen() }
        composable("menu") { MenuScreen() }
        composable("favorite") { FavoriteScreen() }
        composable("delete") { DeleteScreen() }
        composable("profile") { UserProfileScreen(navController) }
    }
}
