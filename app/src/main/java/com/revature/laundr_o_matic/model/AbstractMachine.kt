package com.revature.laundr_o_matic.model

import java.time.LocalTime


/**
 * A base class for our machines
 *
 * Allows for creation of multiple types of machines and sizes
 */
abstract class AbstractMachine(val id:Int,
                               var nCost:Float=5.00f,
                               var nRunTime:LocalTime = LocalTime.of(0,40),
                               var nLoadSize:Int = 2,
                               var reservations:Reservations = Reservations())