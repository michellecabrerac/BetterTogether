package com.bettertogether.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bettertogether.model.Historic

@Composable
fun HistoricalScreen(onClick: () -> Unit) {


    AllHistorics(
        listOf(
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            ),
            Historic(
                meetingPlace = "Barcelona",
                hour = "08:00h",
                destination = "Boehringer Ingelheim"
            )
        )
    )

}


@Composable
fun AllHistorics(historicList: List<Historic>) {

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
                    "Histórico de viajes",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp

                )
            }
        }

        items(historicList) {
            HistoricCard(
                meetingPlace = it.meetingPlace,
                destination = it.destination,
                hour = it.hour
            )
        }

        item {
          Spacer(modifier = Modifier.height(40.dp))
        }
    }


}


@Composable
fun HistoricCard(meetingPlace: String, destination: String, hour: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(Modifier.padding(8.dp)) {
                Text(
                    text = meetingPlace,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = hour,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = destination,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}