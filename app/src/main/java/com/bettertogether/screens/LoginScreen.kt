package com.bettertogether.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bettertogether.MainActivity
import com.bettertogether.R
import com.bettertogether.screens.viewmodels.MainActivityVM
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LoginScreen( onSignUpClick: () -> Unit, viewModel: MainActivityVM, activity: MainActivity) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
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


        OutlinedButton(
            border = BorderStroke(1.dp, Color.Black),

            modifier = Modifier.size(height = 60.dp, width = 200.dp),

            onClick = {
                      /*TODO OJOOO aquí hacemos autenticación*/

                onSignUpClick()

                      },
            elevation = ButtonDefaults.elevation(10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Google Button",
                    Modifier.size(30.dp, 30.dp)
                )

                Text(text = "Login with Google")
            }
        }

    }
}
