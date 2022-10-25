package com.bettertogether.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bettertogether.screens.*
import com.bettertogether.screens.components.BottomBarScreen
import com.bettertogether.screens.map.MapVM
import com.bettertogether.screens.viewmodels.MainActivityVM


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapNavGraph(navController: NavHostController, viewModel: MainActivityVM) {
    NavHost(
        navController = navController,
        route = Graph.MAP,
        startDestination = BottomBarScreen.Map.route
    ) {
        composable(route = BottomBarScreen.Map.route) {
            MapScreen(
                viewModel = viewModel,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }

        composable(route = BottomBarScreen.List.route) {
            TravelListScreen(
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }
        composable(route = BottomBarScreen.Publish.route) {

            PublishTripScreen(
                onClick = {}
            )
        }
        composable(route = BottomBarScreen.Historical.route) {
            HistoricalScreen(onClick = { })
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            ScreenContent(name = DetailsScreen.Information.route) {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }
        composable(route = DetailsScreen.Overview.route) {
            ScreenContent(name = DetailsScreen.Overview.route) {
                navController.popBackStack(
                    route = DetailsScreen.Information.route,
                    inclusive = false
                )
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}
