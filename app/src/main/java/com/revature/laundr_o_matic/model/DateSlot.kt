package com.revature.laundr_o_matic.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.collections.ArrayList


/**
 * Class to represent a reservation's Day
 */
class DateSlot(var Date: LocalDate) {

    var reservation_times = ArrayList<TimeSlot>()

    init{

        //go through each hour and assign to the TimeSlot
        for (i in 6..20) {
            var startTime = LocalTime.of(i,0)
            reservation_times.add(TimeSlot(startTime,false))

        }
    }


}