package com.rodrigojscript.percentplan.model

class PercentRepository {

    // Esta función recibe la cantidad de ingresos y calcula los porcentajes de gastos y ahorros
    fun calculatePercentages(cantidadIngresos: Double): Map<String, Double> {
        val myExpenses = cantidadIngresos * 0.5
        val personalFixedExpenses = cantidadIngresos * 0.3 * 0.7
        val debts = cantidadIngresos * 0.3 * 0.3
        val emergencyFund = cantidadIngresos * 0.2 * 0.7
        val savingForYou = cantidadIngresos * 0.2 * 0.3

        return mapOf(
            "myExpenses" to myExpenses,
            "personalFixedExpenses" to personalFixedExpenses,
            "debts" to debts,
            "emergencyFund" to emergencyFund,
            "savingForYou" to savingForYou
        )
    }

}
