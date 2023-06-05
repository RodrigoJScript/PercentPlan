package com.rodrigojscript.percentplan.ui.theme


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rodrigojscript.percentplan.NavGraph
import com.rodrigojscript.percentplan.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Splash()

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(NavGraph.Main.route)
    }
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = true) {
            Image(
                painter = painterResource(id = R.drawable.splashpercentplan),
                contentDescription = "LOGO",
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(percent = 50)),
                contentScale = ContentScale.Fit
            )
        }
    }
}

