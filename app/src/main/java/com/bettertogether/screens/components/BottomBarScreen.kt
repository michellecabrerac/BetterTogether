package com.bettertogether.screens.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object List : BottomBarScreen(
        route = "LIST",
        title = "Lista",
        icon = Icons.Default.List

    )

    object Map : BottomBarScreen(
        route = "MAP",
        title = "Mapa",
        icon = Icons.Default.LocationOn
    )


    object Publish : BottomBarScreen(
        route = "PUBLISH",
        title = "Publicar",
        icon = Icons.Default.AddCircle
    )

    object Historical : BottomBarScreen(
        route = "HISTORICAL",
        title = "Historico",
        icon = Icons.Default.Favorite
    )
}