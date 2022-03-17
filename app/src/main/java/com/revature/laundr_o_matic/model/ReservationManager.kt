package com.revature.laundr_o_matic.model

import com.revature.laundr_o_matic.model.DateSlot
import java.text.SimpleDateFormat
import java.util.*

/**
 * Manager class used to control our reservations
 */
class ReservationManager() {

    //Days are stored in a day/month format
    private val dateFormat = SimpleDateFormat("dd/M")
    var mDays = ArrayList<DateSlot>()

    init{
        //capture the date/time in a temporary val
        val currentDate = Date()

        //add 4 days to our mDays list, adding 1 day for each iteration
        for (i in 0..3) {
            var sDate = dateFormat.format(currentDate.getTime() + ((1000 * 60 * 60 * 24)*i))
            mDays.add(DateSlot(sDate = sDate))
        }

    }

    /**
     * Add a reservation
     *
     * nDay - Day of reservation, 1 - 4
     * nHour - Hour of reservation, 24 hour format
     * machineID - ID of the machine we want to reserve
     */
    fun addReservation(nDay:Int,nHour:Int,machineID:Int){
        mDays[nDay-1].addReservation(nHour, machineID)
    }

    /**
     * Remove a reservation
     *
     * nDay - Day of reservation, 1 - 4
     * nHour - Hour of reservation, 24 hour format
     * machineID - ID of the machine we want to reserve
     */
    fun removeReservation(nDay:Int,nHour:Int,machineID:Int){
        mDays[nDay-1].removeReservation(nHour, machineID)
    }
}