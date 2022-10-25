package com.bettertogether.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bettertogether.MainActivity
import com.bettertogether.screens.LoginScreen
import com.bettertogether.screens.viewmodels.MainActivityVM
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.delay
import java.util.Observer


@OptIn(ExperimentalPermissionsApi::class)
fun NavGraphBuilder.authNavGraph(navController: NavHostController, viewModel: MainActivityVM, activity: MainActivity) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {

            LaunchedEffect(key1 = true) {
                viewModel.userLogged.observeForever {
                    if (it) navController.navigate(Graph.MAP)
                }

            }

            LoginScreen(
                viewModel = viewModel,
                onSignUpClick = {
                    navController.popBackStack()

                    viewModel.loginWithGoogle(activity)

                },
                activity = activity
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
}