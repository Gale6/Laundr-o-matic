package com.revature.laundr_o_matic.model

import java.io.Serializable
import java.time.LocalDate

/**\
 * Holds an array for the next 4 days
 */
class Reservations: Serializable {

    //ArrayList of 4 DateSlots
    var days = ArrayList<DateSlot>()

    init{

        //Add 4 days to the arraylist
        for ( i in 0..3){

            days.add(DateSlot(LocalDate.now().plusDays(i.toLong())))
        }
    }

    fun addDate(date: LocalDate){
        days.add(DateSlot(date))
    }
}