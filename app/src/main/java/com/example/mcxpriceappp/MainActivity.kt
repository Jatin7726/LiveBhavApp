package com.example.mcxpriceappp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.mcxpriceappp.presentation.MainScreen
import com.example.mcxpriceappp.presentation.SplashScreen
import com.example.mcxpriceappp.ui.theme.McxpriceapppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            McxpriceapppTheme {
                MainScreen()
            }
        }
    }
}
//
//@Composable
//fun AppEntry() {
//    var showSplash by remember { mutableStateOf(true) }
//
//    LaunchedEffect(Unit) {
//        delay(2000) // wait 2 seconds
//        showSplash = false
//    }
//
//    if (showSplash) {
//        SplashScreen()
//    } else {
//        MainScreen()
//    }
//}
