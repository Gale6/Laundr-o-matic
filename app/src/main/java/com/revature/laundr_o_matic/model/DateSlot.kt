package com.revature.laundr_o_matic.model

import kotlin.collections.ArrayList


/**
 * Class to represent a reservation's Day
 *
 * Contains an arraylist of TimeSlots, each representing an hour in the day
 */
class DateSlot(var sDate: String ) {

    /*
        Hold a list of TimeSlot hours
        Each hour is indexed at its 24hour format time -1
        i.e. 2 pm would be at index 13
    */
    private var mHours = ArrayList<TimeSlot>()

    init{

        //go through each hour and assign to the TimeSlot
        for (i in 1..24) {
            var sAmPm = if(i<13) "am" else "pm"
            var nTime = i
            if (nTime >12) nTime-=12
                mHours.add(TimeSlot("$nTime:00 $sAmPm"))
        }
    }

    /**
     * Get a specific TimeSlot hour
     *
     * Pass the hour you want in 24hour format
     * */
    fun getHour(hour:Int): TimeSlot = mHours[hour-1]

    /**
     * Add a reservation at the hour passed to the target machine's ID
     *
     * Pass the hour you want in 24hour format
     */
    fun addReservation(hour:Int,machineID:Int){
        mHours[hour-1].addReservation(machineID)
    }

    /**
     * Remove a reservation at the hour passed to the target machine's ID
     *
     * Pass the hour you want in 24hour format
     */
    fun removeReservation(hour:Int,machineID:Int){
        mHours[hour-1].removeReservation(machineID)
    }

    /**
     * Retrieve the TimeSlot Arraylist this Date holds
     */
    fun getHours():ArrayList<TimeSlot> = mHours


    /**
     * Returns the ArrayList of reservations at the Hour given
     *
     * Pass the hour you want in 24hour format
     */
    fun getReservations(hour:Int):ArrayList<Int> = mHours[hour-1].getReservations()

    /**
     * Checks if the machine passed has an available reservation at the Hour given
     *
     * Pass the hour you want in 24hour format
     */
    fun checkReservation(hour:Int,machineID: Int):Boolean = mHours[hour-1].checkReservation(machineID)

}