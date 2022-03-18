package com.revature.laundr_o_matic.model

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Holds the Users current Reservations
 */
class UserReservations(): Serializable {

    private var currentReservations = ArrayList<ReservedSlot>()


    /**
     * Adds the passed in reservation's date and time to
     * the user's current reservations
     */
    fun addReservation(time: LocalTime, date:LocalDate, machineID:Int) =
        currentReservations.add(ReservedSlot(LocalDateTime.of(date,time), machineID))

    /**
     * Removes the passed in LocalDateTime from the user's
     * current reservations
     */
    fun removeReservation(reservation:ReservedSlot){
        if (currentReservations.contains(reservation)) currentReservations.remove(reservation)
    }

    /**
     * Retrieves the user's Reservations
     */
    fun getReservations():ArrayList<ReservedSlot> = currentReservations

}