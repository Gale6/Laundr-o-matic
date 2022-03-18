package com.revature.laundr_o_matic.model


/**
 * Default Dryer Class
 */
class Dryer(id:Int,
            reservations: Reservations): AbstractMachine(id
                                                        ,nCost = 4.50f,
                                                        nRunTime = 50,
                                                        nLoadSize = 3, reservations) {
}