package com.example.contador.ui.screens

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp

@Composable
fun AdivinarScreen() {

    var numeroAleatorio by remember { mutableStateOf((1..100).random()) }
    var numeroIngresado by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var contador by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.statusBarsPadding().fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedTextField(value = numeroIngresado, onValueChange = { numeroIngresado = it }, modifier = Modifier.width(60.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button (onClick = {
                if (numeroIngresado != "") {

                    if (numeroAleatorio.toDouble() == numeroIngresado.toDouble()) {

                        resultado = "Acertaste"
                        numeroAleatorio = (1..100).random()

                    } else {

                        if (numeroIngresado.toDouble() < numeroAleatorio) {

                            resultado = "El numero debe ser mayor"


                        } else {

                            resultado = "El numero debe ser menor"

                        }

                        if (contador == 10) {
                            resultado = "Lo sentimos, llevas 10 intentos. Perdiste"
                            numeroAleatorio = (1..100).random()

                        } else {

                            contador++

                        }
                    }
                } else {
                    resultado = "Primero ingresa un numero (1-100)"
                }
            }) {Text("Adivinar")}

            Button (onClick = {

                resultado = "El numero era: " + numeroAleatorio.toString()
                numeroAleatorio = (1..100).random()
                contador = 0


            }) {Text("Rendirse")}

            Button (onClick = {

                numeroAleatorio = (1..100).random()
                resultado = "Se reinició el numero"
                contador = 0

            }) {Text("Reiniciar")}
        }

        Text(resultado)
        Text("Llevas " + contador.toString() + " intentos")
    }
}