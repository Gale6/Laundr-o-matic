package com.revature.laundr_o_matic.model

class MachineManager {
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

    //Retrieve a map of all the Dryers
    fun getDryers():HashMap<Int, Dryer>{
        val mDryers = HashMap<Int, Dryer>()
        for(item in mMachines){
            if(item.value is Dryer) mDryers[item.key] = item.value as Dryer
        }
        return mDryers

    }
    //Retrieve a map of all the Washers
    fun getWashers():HashMap<Int, Washer>{
        val mWashers = HashMap<Int, Washer>()
        for(item in mMachines){
            if(item.value is Washer) mWashers[item.key] = item.value as Washer
        }
        return mWashers

    }
    //Access a machine in the map with an ID
    fun getMachine(nKey:Int): AbstractMachine? = mMachines[nKey]

    //Get a new ID for a machine
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