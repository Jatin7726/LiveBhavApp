package com.example.mcxpriceappp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mcxpriceappp.R

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally  // Center items horizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.brandnamewithlogo),
                contentDescription = "App Logo",
                modifier = Modifier.size(350.dp)
            )

        }
    }
}
