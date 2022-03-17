package com.revature.laundr_o_matic.model

/**
 * Manager class to control our different machines
 */
class MachineManager {

    //Map of all our machines
    private var mMachines = HashMap<Int, AbstractMachine>()

    //Initialize the manager with some washers and dryers
    init {
        //Load in some quick washers
        for(i in 1..6){
            val nKey = getUniqueID()
            mMachines[nKey] = Washer(nKey)
        }
        //Load in some quick dryers
        for(i in 1..6){
            val nKey = getUniqueID()
            mMachines[nKey] = Dryer(nKey)
        }
    }

    /**
     * Retrieve a map of just our Dryers
     */
    fun getDryers():HashMap<Int, Dryer>{

        //Create our Map
        val mDryers = HashMap<Int, Dryer>()

        //Loop through all machines, checking if they are a Dryer
        for(item in mMachines){
            if(item.value is Dryer) mDryers[item.key] = item.value as Dryer
        }
        return mDryers
    }

    /**
     * Retrieve a map of all the Washers
     */
    fun getWashers():HashMap<Int, Washer>{

        //Create our Map
        val mWashers = HashMap<Int, Washer>()

        //Loop through all machines, checking if they are Washers
        for(item in mMachines){
            if(item.value is Washer) mWashers[item.key] = item.value as Washer
        }
        return mWashers
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