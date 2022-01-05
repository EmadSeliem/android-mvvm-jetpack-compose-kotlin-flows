package com.compose.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.compose.books.common.Navigation
import com.compose.books.presentaion.ui.theme.BooksTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            BooksTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}