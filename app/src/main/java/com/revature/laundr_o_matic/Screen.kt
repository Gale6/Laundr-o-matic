package com.revature.laundr_o_matic

sealed class Screen(val route:String){
    object CurrentMachine: Screen(route = "CurrentMachineScreen")
    object Login: Screen(route = "LoginScreen")
    object MachineDetails:Screen(route = "MachineDetails")
    object MachineReservation:Screen(route = "MachineReservation")
    object MachineInUse:Screen(route = "MachineInUse")
    object MainMenu:Screen(route = "MainMenu")
    object MissedReservation:Screen(route = "MissedReservation")
    object Registration:Screen(route = "Registration")
    object RegistrationSuccessful:Screen(route = "RegistrationSuccessful")
    object ReservationSuccessful:Screen(route = "ReservationSuccessful")
    object ReservationTime:Screen(route = "ReservationTime")
    object UpcomingReservation:Screen(route = "UpcomingReservation")
    object UserProfile:Screen(route = "UserProfile")
    object Wallet:Screen(route = "Wallet")



}