package com.unonomercy.core

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.unonomercy.core.ui.navigation.AppScreen
import com.unonomercy.core.ui.theme.UnoNoMercyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenSplash = installSplashScreen()
        screenSplash.setKeepOnScreenCondition { false }
        
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        enableEdgeToEdge()
        
        setContent {
            val appStyles = Modifier.fillMaxSize()

            UnoNoMercyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = appStyles,
                ) { AppScreen() }
            }
        }
    }
}
