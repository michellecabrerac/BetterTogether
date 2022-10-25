package com.bettertogether.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventSeat
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bettertogether.R
import com.bettertogether.model.Historic


@Composable
fun TravelListScreen(onClick: () -> Unit) {
    Travels(
        listOf(
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim",
                seats = "3/4"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim",
                seats = "3/4"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim",
                seats = "3/4"
            ),
        )
    )
}


@Composable
fun Travels(listTravels: List<Historic>) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 25.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Viajes disponibles",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp

                )
            }
        }

        items(listTravels) {
            TravelCard(
                meetingPlace = it.meetingPlace,
                destination = it.destination,
                hour = it.hour,
                seats = it.seats ?: "X/X"
            )
        }


    }


}


@Composable
fun TravelCard(meetingPlace: String, destination: String, hour: String, seats: String) {
    var enabled by rememberSaveable { mutableStateOf(true) }
    var seats by rememberSaveable { mutableStateOf("3/4") }


    Card(
        modifier = Modifier
            .border(1.dp, androidx.compose.ui.graphics.Color.Black)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Spacer(modifier = Modifier.weight(2f))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "User Image",
                    Modifier
                        .size(60.dp, 60.dp)
                        .clip(CircleShape)
                        .border(width = 1.dp, color = LightGray, shape = CircleShape)
                )
            }
            Spacer(modifier = Modifier.weight(2f))
            Column {

                IconText(icon = Icons.Default.LocationOn, text = meetingPlace)
                IconText(icon = Icons.Default.LockClock, text = hour)
                IconText(icon = Icons.Default.EventSeat, text = seats)
            }
            Spacer(modifier = Modifier.weight(10f))
            Column {

                OutlinedButton(onClick = {
                    enabled = false
                    seats = "2/4"
                }, enabled = enabled) {

                    Text(text = "Unirse")
                }

            }
            Spacer(modifier = Modifier.weight(2f))

        }
    }
}


@Composable
fun IconText(icon: ImageVector, text: String) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Icon(
            imageVector = icon,
            contentDescription = "Icon",
            Modifier.padding(top = 2.dp, bottom = 2.dp, end = 2.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
        )

    }
}