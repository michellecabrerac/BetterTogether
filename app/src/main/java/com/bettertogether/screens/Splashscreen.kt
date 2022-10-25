package com.bettertogether.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bettertogether.R
import com.bettertogether.navigation.Graph
import com.bettertogether.navigation.MapNavGraph
import com.bettertogether.navigation.authNavGraph
import com.bettertogether.navigation.detailsNavGraph
import com.bettertogether.screens.components.BottomBarScreen
import kotlinx.coroutines.delay

@Composable
fun Splashscreen(navController: NavHostController = rememberNavController()) {
    /*LaunchedEffect(key1 = true) {
        //utilizar para cargar datos por ejemplo
        delay(1000)
        navController.popBackStack()
        //Todo: navigate to
    }*/
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo BetterTogether",
            Modifier.size(150.dp, 150.dp)
        )

        Text(
            "Better Together",
            fontSize = 30.sp
        )

    }
}