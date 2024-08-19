package com.example.mobileuptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.defaultComponentContext
import com.example.mobileuptest.di.KoinDI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            KoinDI.init()
        }
        enableEdgeToEdge()
        val root = DefaultRootComponent(componentContext = defaultComponentContext())

        setContent {
            MainView(component = root)
        }
    }
}
