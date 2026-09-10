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
import androidx.compose.ui.unit.dp

@Composable
fun OperacionScreen() {

    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var operacion by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.statusBarsPadding().fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedTextField(value = n1, onValueChange = { n1 = it }, modifier = Modifier.width(60.dp))
            OutlinedTextField(value = operacion, onValueChange = { operacion = it }, modifier = Modifier.width(60.dp))
            OutlinedTextField(value = n2, onValueChange = { n2 = it }, modifier = Modifier.width(60.dp))
        }
        Button(onClick = {}) {

            var primerValor = n1.toDoubleOrNull()
            var segundoValor = n2.toDoubleOrNull()

            if (primerValor != null && segundoValor != null && operacion != "") {

                resultado = when(operacion) {

                    "+" -> {
                        (primerValor + segundoValor).toString()
                    }

                    "-" -> {
                        (primerValor - segundoValor).toString()
                    }

                    "*" -> {
                        (primerValor * segundoValor).toString()
                    }

                    "/" -> { if (segundoValor.toInt() == 0) {
                        "No se puede dividir entre 0"
                    } else {
                        (primerValor / segundoValor).toString()
                    }}

                    else -> { "Operador no conocido" }

                }

            }

            Text("Calcular")
        }

        Text(resultado)
    }
}