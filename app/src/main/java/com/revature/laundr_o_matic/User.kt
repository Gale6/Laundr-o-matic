package com.revature.laundr_o_matic

import com.revature.laundr_o_matic.model.*
import java.io.Serializable

data class User (
    val username:String,
    val password:String,
    var runningWasher: ReservedSlot? = null,
    var runningDryer:ReservedSlot? = null,
    var reservedWasher:ReservedSlot? = null,
    var reservedDryer: ReservedSlot? = null
) :Serializable
