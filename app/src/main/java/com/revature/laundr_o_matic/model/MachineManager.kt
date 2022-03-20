package com.revature.laundr_o_matic.model

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Manager class to control our different machines
 */
class MachineManager: Serializable {

    //Map of all our machines
    private var mMachines = HashMap<Int, AbstractMachine>()

    //Initialize the manager with some washers and dryers
    init {

        //Load in some quick washers
        for(i in 1..6){

            val nKey = getUniqueID()
            mMachines[nKey] = Washer(nKey, Reservations())
        }

        //Load in some quick dryers
        for(i in 1..6){

            val nKey = getUniqueID()
            mMachines[nKey] = Dryer(nKey,Reservations())
        }
    }

    fun updateMachines(currentTime:LocalDateTime){

        //for each machine
        val machineItr = mMachines.iterator()
        while (machineItr.hasNext()){

            val mValue = machineItr.next().value

            //for each day
            updateDates(currentTime,mValue.reservations.days)
        }
    }

    fun updateDates(currentTime: LocalDateTime,dateArray:ArrayList<DateSlot>) {

        var removeList = ArrayList<DateSlot>()
        var addList = ArrayList<DateSlot>()

        var dateItr = dateArray.iterator()
        var dateAdd:Long = 1
        while (dateItr.hasNext()) {
            var date = dateItr.next()

            //if the current time is greater than the reservation date
            if (currentTime >= LocalDateTime.of(date.Date.plusDays(1), LocalTime.of(0, 0))) {

                //remove the date
                removeList.add(date)
                //dateItr.remove()

                //add new day
                addList.add(DateSlot(dateArray.last().Date.plusDays(dateAdd)))
                dateAdd++
                //dateArray.add(DateSlot(LocalDate.now().plusDays(3)))
            }
            //if the date hasn't passed, check the times
            else {
                updateTimes(currentTime, date.reservation_times, date.Date)

            }
        }
        dateArray.removeAll(removeList)
        dateArray.addAll(addList)
    }

    fun updateTimes(currentTime: LocalDateTime,timeArray: ArrayList<TimeSlot>, date: LocalDate){

        var removeList = ArrayList<TimeSlot>()

        val timeItr = timeArray.iterator()
        while (timeItr.hasNext()){
            var time = timeItr.next()
            //if the current time is greater than the reservation's time
            if (currentTime >= LocalDateTime.of(date, time.hour)) {

                //remove that reservation
                removeList.add(time)
                //timeItr.remove()
            }
        }
        timeArray.removeAll(removeList)
    }

    /**
     * Retrieve a map of all machines
     *
     * Machines are in AbstractMachine class -
     * check type using is Washer or is Dryer
     */
    fun getMachines():HashMap<Int,AbstractMachine>{
        return mMachines
    }

    /**
     * Access a machine in the map with the machine's ID
     *
     * Only returns an abstract machine, must check for machine type when received
     */
    fun getMachine(nKey:Int): AbstractMachine? = mMachines[nKey]

    /**
     * Finds an unused ID for machineID assignment
     */
    private fun getUniqueID():Int{
        var nNewKey = 0

        //while the new key is in the machines map, increment the key value and check again
        while(mMachines.containsKey(nNewKey)){
            nNewKey++
        }

        //return the key when we find a free key value
        return nNewKey
    }
}