package com.coderbee.veganloversclub

import MealsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.coderbee.veganloversclub.ui.theme.VeganLoversClubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VeganLoversClubTheme {
                    MealsScreen()
            }
        }
    }
}