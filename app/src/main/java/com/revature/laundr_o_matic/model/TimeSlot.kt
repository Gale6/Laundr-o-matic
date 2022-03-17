package com.revature.laundr_o_matic.model

/**
 * Class representing an hour reservation timeslot with an arraylist of machinesIDs
 * that are currently reserved this hour
 */
data class TimeSlot(val sHour:String,
                    private var machineReservations: ArrayList<Int> = ArrayList<Int>()) {

    /**
     * Get the ArrayList of Reservations at this TimeSlot
     */
    fun getReservations():ArrayList<Int> = machineReservations


    /**
     * Remove the machine id from the reservation list
     */
    fun removeReservation(machineID: Int){
        //Make sure the reservation is in the arraylist and remove
        if (machineReservations.contains(machineID)) machineReservations.remove(machineID)
    }

    /**
     * Adds the machine id to the current reservation list
     */
    fun addReservation(machineID: Int) {
        //Check if the reservation is already in the list, if not add it
        if(!machineReservations.contains(machineID)) machineReservations.add(machineID)
    }

    /**
     * Checks if the machine id has a reservation for this timeslot
     */
    fun checkReservation(machineID:Int):Boolean = machineReservations.contains(machineID)
}