package com.revature.laundr_o_matic

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navController: NavHostController){

    NavHost(navController = navController, startDestination = Screen.MainMenu.route){
        composable(route= Screen.CurrentMachine.route){
            CurrentMachineScreen(navController = navController)
        }
        composable(route= Screen.Login.route){
            LogInScreen(navController = navController)
        }
        composable(route = Screen.MachineDetails.route){
            MachineDetailsScreen(navController = navController)
        }
        composable(route = Screen.MachineReservation.route){
            MachineReservationScreen(navController = navController)
        }
        composable(route = Screen.MachineInUse.route){
            MachinesInUseScreen(navController = navController)
        }
        composable(route = Screen.MainMenu.route){
            MainMenuScreen(navController = navController)
        }
        composable(route = Screen.MissedReservation.route){
            MissedReservationScreen(navController = navController)
        }
        composable(route = Screen.Registration.route){
            RegistrationScreen(navController = navController)
        }
        composable(route = Screen.RegistrationSuccessful.route){
            RegistrationSuccessfulScreen(navController = navController)
        }
        composable(route = Screen.ReservationSuccessful.route){
            ReservationSuccessfulScreen(navController = navController)
        }
        composable(route = Screen.ReservationTime.route){
            ReservationTimeScreen(navController = navController)
        }
        composable(route = Screen.UpcomingReservation.route){
            UpcomingReservationScreen(navController = navController)
        }
        composable(route = Screen.UserProfile.route){
            UserProfileScreen(navController = navController)
        }
        composable(route = Screen.Wallet.route){
            WalletScreen(navController = navController)
        }


    }
}