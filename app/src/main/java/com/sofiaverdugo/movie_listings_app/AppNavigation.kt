package com.sofiaverdugo.movie_listings_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val start: String = if(Firebase.auth.currentUser!=null) {"movies"} else{"login"}
    NavHost(
        navController = navController,
        startDestination = start,
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                onLoginOk = {
                    navController.navigate("movies") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onSignUp = { navController.navigate("signup") }
            )
        }
        composable("signup") {
            SignupScreen(
                onSignupOK = {
                    navController.navigate("movies") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onCancel = { navController.popBackStack() }
            )
        }

        composable("movies") {
            MovieScreen(
                user = Firebase.auth.currentUser?.email ?: "",
                onMovieClick = { id ->
                    navController.navigate("detail/$id")
                },
                onLogout = {
                    Firebase.auth.signOut()
                    navController.navigate("login") {
                        popUpTo("movies") { inclusive = true }
                    }
                }
            )
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { entrada ->
            val id = entrada.arguments?.getInt("id") ?: 1
            DetailScreen(
                movieId = id,
                onBack = { navController.popBackStack() }
            )
        }
    }
}