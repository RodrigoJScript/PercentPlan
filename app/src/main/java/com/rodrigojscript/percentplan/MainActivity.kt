package com.rodrigojscript.percentplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rodrigojscript.percentplan.ui.screens.Main
import com.rodrigojscript.percentplan.ui.theme.BaseAppTheme
import com.rodrigojscript.percentplan.viewmodel.PercentPlanViewModel

class MainActivity : ComponentActivity() {
    private val viewModel = PercentPlanViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseAppTheme {
                AppNavigation()
            }
        }
    }
}