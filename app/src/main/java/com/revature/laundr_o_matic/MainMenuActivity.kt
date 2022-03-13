package com.revature.laundr_o_matic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

class MainMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundromaticTheme {

            }
        }
    }
}