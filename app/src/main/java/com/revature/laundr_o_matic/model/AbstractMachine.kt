package com.revature.laundr_o_matic.model


/**
 * A base class for our machines
 *
 * Allows for creation of multiple types of machines and sizes
 */
abstract class AbstractMachine(val id:Int,
                               var nCost:Float=5.00f,
                               var nRunTime:Int = 40,
                               var nLoadSize:Int = 2,
                               var reservations:Reservations = Reservations()) {


}