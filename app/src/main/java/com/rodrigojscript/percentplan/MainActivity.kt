package com.rodrigojscript.percentplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigojscript.percentplan.model.PercentRepository
import com.rodrigojscript.percentplan.ui.screens.Main
import com.rodrigojscript.percentplan.ui.theme.BaseAppTheme
import com.rodrigojscript.percentplan.ui.theme.PercentPlanTheme
import com.rodrigojscript.percentplan.viewmodel.PercentPlanViewModel

class MainActivity : ComponentActivity() {
    private val viewModel = PercentPlanViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseAppTheme {
                Main(viewModel)
            }
        }
    }
}