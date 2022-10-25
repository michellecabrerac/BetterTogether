package com.bettertogether.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bettertogether.screens.components.DatePicker
import com.bettertogether.screens.components.TimePicker


@Composable
fun PublishTripScreen(
    onClick: () -> Unit
) {
    val destination = listOf("Elegir destino", "Casa", "Trabajo")
    val seats = listOf("Elegir número", "1", "2", "3", "4")

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            modifier = Modifier.padding(top = 40.dp, start = 20.dp, bottom = 40.dp),
            text = "Publicar viaje",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        MiddlePart("¿Dónde ir?", destination)
        Spacer(modifier = Modifier.height(50.dp))
        MiddlePart("Número de asientos disponibles", seats)
        Spacer(modifier = Modifier.height(50.dp))
        LocationPlace()
        Spacer(modifier = Modifier.height(50.dp))
        TimePicker(label = "Hora de salida", value = "16:00", onValueChange = {})
        Spacer(modifier = Modifier.height(50.dp))
        DatePicker()
        Spacer(modifier = Modifier.height(50.dp))
        BottomPart()


    }


}


@Composable
fun HourPicker() {

}

@Composable
fun LocationPlace() {
    var text by rememberSaveable { mutableStateOf("Localización") }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text("Punto de encuentro") },
        maxLines = 1,
    )

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MiddlePart(label: String, options: List<String>) {

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}

@Composable
fun BottomPart() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            onClick = { /*TODO*/ }) {
            Box() {
                Text(text = "CANCELAR")
            }
        }

        Spacer(modifier = Modifier.width(50.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            onClick = { /*TODO*/ }
        ) {
            Box() {
                Text(text = "ACEPTAR")
            }
        }
    }
}