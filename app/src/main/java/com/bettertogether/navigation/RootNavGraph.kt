package com.bettertogether.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bettertogether.MainActivity
import com.bettertogether.screens.MainScreen
import com.bettertogether.screens.map.MapVM
import com.bettertogether.screens.viewmodels.MainActivityVM
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RootNavigationGraph(navController: NavHostController, viewModel: MainActivityVM, activity: MainActivity) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController, viewModel = viewModel, activity)

        composable(route = Graph.MAP) {
            MainScreen(viewModel = viewModel)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAP = "map_graph"
    const val SPLASH = "map_graph"
    const val DETAILS = "details_graph"
}