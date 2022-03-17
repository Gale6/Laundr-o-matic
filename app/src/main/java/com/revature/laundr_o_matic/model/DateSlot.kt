package com.revature.laundr_o_matic.model

import kotlin.collections.ArrayList

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

    //Get a specific TimeSlot hour
    //Pass the hour you want in 24hour format
    fun getHour(hour:Int): TimeSlot = mHours[hour-1]

    fun addReservation(hour:Int,machineID:Int){
        mHours[hour-1].addReservation(machineID)
    }
    fun removeReservation(hour:Int,machineID:Int){
        mHours[hour-1].removeReservation(machineID)
    }
    fun getHours():ArrayList<TimeSlot> = mHours
    fun getReservations(hour:Int):ArrayList<Int> = mHours[hour-1].getReservations()
    fun checkReservation(hour:Int,machineID: Int):Boolean = mHours[hour-1].checkReservation(machineID)

}