package com.revature.laundr_o_matic.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.revature.laundr_o_matic.User
import com.revature.laundr_o_matic.model.AbstractMachine
import com.revature.laundr_o_matic.model.DateSlot
import com.revature.laundr_o_matic.model.MachineManager
import java.time.LocalDateTime
import java.time.LocalTime

class MainViewModel:ViewModel() {

    //Reservation Selection Variables
    var machineManager = MachineManager()
    lateinit var selectedMachine:AbstractMachine
    lateinit var selectedDate: MutableState<DateSlot>
    lateinit var selectedTime: LocalTime

    //User
    var user: User? = null

    //Timer
    private var currentTime:LocalDateTime = LocalDateTime.now()


    /**
     * Update the view model based on the current time
     */
    fun update() {

        currentTime = LocalDateTime.now()

        updateUser()

        machineManager.updateMachines(currentTime)
    }

    /**
     * Update the user
     */
    private fun updateUser(){

        if (user != null) {

            //update reservations
            if (user?.reservedDryer != null) {

                if (user?.reservedDryer?.reservationTime != null) {
                    if (user?.reservedDryer?.reservationTime!! <= currentTime) {
                        user?.runningDryer = user?.reservedDryer
                        user?.reservedDryer = null
                    }
                }
            }
            if (user?.reservedWasher != null) {

                if (user?.reservedWasher?.reservationTime != null) {
                    if (user?.reservedWasher?.reservationTime!! <= currentTime) {
                        user?.runningWasher = user?.reservedWasher
                        user?.reservedWasher = null
                    }
                }
            }

            //update the running machines
            if (user?.runningDryer != null){
                if (user?.runningDryer?.reservationTime != null) {

                    //If the running machine's start time plus its run time is greater than the
                    // current time, remove the machine
                    if ((user?.runningDryer?.reservationTime!!.plusMinutes(
                            user?.runningDryer?.machine!!.nRunTime.minute.toLong())) <= currentTime)
                            {
                                user?.runningDryer = null
                            }
                }
            }

            if (user?.runningWasher != null) {
                if (user?.runningWasher?.reservationTime != null) {

                    //If the running machine's start time plus its run time is greater than the
                    // current time, remove the machine
                    if (user?.runningWasher?.reservationTime!!.plusMinutes(
                            user?.runningWasher?.machine!!.nRunTime.minute.toLong()) <= currentTime)
                            {
                                user?.runningWasher = null
                            }
                }
            }
        }
    }

}