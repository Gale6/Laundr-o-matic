package com.revature.laundr_o_matic.model

import java.time.LocalTime

/**
 * Class representing an hour reservation timeslot with an arraylist of machinesIDs
 * that are currently reserved this hour
 */
data class TimeSlot(val hour: LocalTime, var bReserved:Boolean) {

}