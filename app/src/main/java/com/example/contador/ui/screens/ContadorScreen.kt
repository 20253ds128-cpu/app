package com.example.contador.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContadorScreen() {

    // Column y Row
    var conteo by rememberSaveable { mutableStateOf (0) }

    Column(modifier = Modifier.statusBarsPadding().fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "$conteo", fontSize = 40.sp)

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {
                // Logica de resta a la variable
                if (conteo > 0) conteo--
            }) {
                Text(text = "-")
            }
            Button(onClick = {
                // Logica de suma a la variable
                conteo++
            }) {
                Text(text = "+")
            }
        }
    }
}