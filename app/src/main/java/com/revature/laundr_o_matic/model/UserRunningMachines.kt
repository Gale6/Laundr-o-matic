package com.revature.laundr_o_matic.model

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class UserRunningMachines(): Serializable {
    var activeMachines = ArrayList<ReservedSlot>()


    /**
     * Adds the passed in reservation's date and time to
     * the user's current reservations
     */
    fun addRunningMachine(time: LocalDateTime, machine:AbstractMachine) =
        activeMachines.add(ReservedSlot(time, machine))

    fun addRunningMachine(reservation:ReservedSlot) = activeMachines.add(reservation)

    /**
     * Removes the passed in LocalDateTime from the user's
     * current reservations
     */
    fun removeRunningMachine(runningMachine:ReservedSlot){
        if (activeMachines.contains(runningMachine)) activeMachines.remove(runningMachine)
    }

    /**
     * Retrieves the user's Reservations
     */
    fun getRunningMachines():ArrayList<ReservedSlot> = activeMachines

}