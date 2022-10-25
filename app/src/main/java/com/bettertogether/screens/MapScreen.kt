package com.bettertogether.screens

import android.util.DisplayMetrics
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bettertogether.navigation.Graph
import com.bettertogether.screens.components.BottomBarScreen.Historical.title
import com.bettertogether.screens.map.MapVM
import com.bettertogether.screens.viewmodels.MainActivityVM
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun MapScreen(onClick: () -> Unit, viewModel: MainActivityVM) {

    //Data

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Expanded
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val mapProperties by remember {
        mutableStateOf(
            MapProperties(
                isMyLocationEnabled = true,
                maxZoomPreference = 13f
            )
        )
    }


    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = true, myLocationButtonEnabled = true)
    }


    val height = LocalConfiguration.current.screenHeightDp.dp


    val initialZoom = 10f
    val finalZoom = 13f
    val destinationLatLng = LatLng(41.58403730424073, 2.016885071218361)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(destinationLatLng, initialZoom)
    }

    LaunchedEffect(key1 = true) {
        cameraPositionState.animate(
            update = CameraUpdateFactory.newCameraPosition(
                CameraPosition(destinationLatLng, finalZoom, 0f, 0f)
            ),
        )
    }


    val driversList = listOf<LatLng>(
        LatLng(41.564346585781536, 2.021647177258365),
        LatLng(41.57879207824357, 2.0166912833404522),
        LatLng(41.57906680626673, 2.012607176417262),
    )


    Column {
        GoogleMap(
            modifier = Modifier.height(height = height - 300.dp),
            properties = mapProperties,
            uiSettings = uiSettings,
            cameraPositionState = cameraPositionState,
        ) {
                driversList.forEach {
                    Marker(
                        position = it,
                        title = "Terrassa",
                        snippet = "8:00h - Parking San Pere Nord"
                    )
            }




        }

        BottomSheetScaffold(
            sheetGesturesEnabled = false,
            scaffoldState = scaffoldState,
            sheetContent = {
                Box(
                    modifier = Modifier
                        //  .fillMaxWidth()
                        .height(300.dp),
                    //.defaultMinSize(1.dp),
                    contentAlignment = Alignment.TopCenter

                ) {

                    Column(
                        //   modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "¿Dónde quieres ir?",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 20.dp)
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Spacer(modifier = Modifier.size(15.dp))
                            basicCard("CASA", isEnabled = true) { viewModel.onHomeClick.postValue(true) }
                            Spacer(modifier = Modifier.size(15.dp))
                            basicCard("TRABAJO", isEnabled = false) { viewModel.onHomeClick.postValue(true) }

                        }


                    }

                }
            },
            sheetBackgroundColor = Color.White,
            sheetElevation = 10.dp,
            sheetPeekHeight = 0.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .defaultMinSize(1.dp),
                contentAlignment = Alignment.Center,
            ) {
            }
        }


    }
}


@Composable
fun basicCard(text: String, isEnabled: Boolean, onClick: () -> Unit) {

    OutlinedButton(
        enabled = isEnabled,
        border = BorderStroke(1.dp, Color.Gray),

        modifier = Modifier.size(height = 70.dp, width = 300.dp),


        onClick = {
            onClick
        },
        elevation = ButtonDefaults.elevation(10.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Gray,
            backgroundColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = text, fontSize = 24.sp)
        }
    }
}

data class AllPositions(
    val name: String,
    val lat: Double,
    val lng: Double
)
