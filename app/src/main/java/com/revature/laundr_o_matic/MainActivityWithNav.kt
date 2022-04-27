package com.revature.laundr_o_matic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.model.MachineManager
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.ui.theme.readMachines
import com.revature.laundr_o_matic.utility.Constants

class MainActivityWithNav : ComponentActivity() {

    lateinit var navController:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundromaticTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()
                    var machines:MachineManager = readMachines(LocalContext.current,Constants.FILEPATH_MACHINES)
                    SetupNavGraph(navController = navController,machines)
                }
            }
        }
    }
}




