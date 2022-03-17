package com.revature.laundr_o_matic.model

data class TimeSlot(val sHour:String,
                    private var machineReservations: ArrayList<Int> = ArrayList<Int>()) {

    //get all reservations of this time
    fun getReservations():ArrayList<Int> = machineReservations

    //Remove the machine id from the reservation list
    fun removeReservation(machineID: Int)=machineReservations.remove(machineID)

    //Adds the machine id to the current reservation list
    fun addReservation(machineID: Int) {
        if(!machineReservations.contains(machineID)) machineReservations.add(machineID)
    }

    //Checks if the machine id has a reservation for this timeslot
    fun checkReservation(machineID:Int):Boolean = machineReservations.contains(machineID)
}