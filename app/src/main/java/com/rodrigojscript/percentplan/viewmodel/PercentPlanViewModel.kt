package com.rodrigojscript.percentplan.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.rodrigojscript.percentplan.model.PercentRepository

class PercentPlanViewModel : ViewModel() {

    val myExpenses = mutableStateOf(0.0)
    val personalFixedExpenses = mutableStateOf(0.0)
    val debts = mutableStateOf(0.0)
    val emergencyFund = mutableStateOf(0.0)
    val savingForYou = mutableStateOf(0.0)

    fun setIncome(cantidadIngreso: Double) {
        if (cantidadIngreso > 0) {
            val percentages = PercentRepository().calculatePercentages(cantidadIngreso)
            myExpenses.value = percentages["myExpenses"] ?: 0.0
            personalFixedExpenses.value = percentages["personalFixedExpenses"] ?: 0.0
            debts.value = percentages["debts"] ?: 0.0
            emergencyFund.value = percentages["emergencyFund"] ?: 0.0
            savingForYou.value = percentages["savingForYou"] ?: 0.0
        } else {
            myExpenses.value = 0.0
            personalFixedExpenses.value = 0.0
            debts.value = 0.0
            emergencyFund.value = 0.0
            savingForYou.value = 0.0
        }
    }
}

