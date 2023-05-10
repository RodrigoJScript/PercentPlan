package com.rodrigojscript.percentplan.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodrigojscript.percentplan.viewmodel.PercentPlanViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(viewModel: PercentPlanViewModel) {
    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Planificación de ingresos",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 20.sp
                )
                val cantidadIngresoText = remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    value = cantidadIngresoText.value,
                    onValueChange = { cantidadIngresoText.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    label = { Text("Ingresa la cantidad de tu ingreso", fontSize = 16.sp) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Gastos Fijos (50%)",
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    fontSize = 18.sp
                )
                Text(
                    text = "Estos son los gastos que debes cubrir mes a mes y que no varían en su cantidad",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Total: ${viewModel.myExpenses.value}",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 16.sp
                )
                Text(
                    text = "Deudas y Gastos propios (30%)",
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    fontSize = 18.sp
                )
                Text(
                    text = "Este porcentaje se divide en 70% para tus gastos personales y 30% para tus deudas",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Gastos personales (70%): ${viewModel.personalFixedExpenses.value}",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 16.sp
                )
                Text(
                    text = "Deudas (30%): ${viewModel.debts.value}",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 16.sp
                )
                Text(
                    text = "Ahorro (20%)",
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    fontSize = 18.sp
                )
                Text(
                    text = "Este porcentaje se divide en 70% para un fondo de emergencia y 30% para tus ahorros personales",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Fondo de emergencia (70%): ${viewModel.emergencyFund.value}",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 16.sp
                )
                Text(
                    text = "Ahorros personales (30%): ${viewModel.savingForYou.value}",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 16.sp
                )
                Button(
                    onClick = {
                        if (cantidadIngresoText.value.text.isNotBlank() && cantidadIngresoText.value.text.toDouble() > 0) {
                            viewModel.setIncome(cantidadIngresoText.value.text.toDouble())
                        } else {
                            // Mostrar mensaje de error o hacer algo más
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Calcular", fontSize = 18.sp)
                }
            }
        }
    }
}