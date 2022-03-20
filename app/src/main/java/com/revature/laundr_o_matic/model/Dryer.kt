package com.revature.laundr_o_matic.model

import java.time.LocalTime


/**
 * Default Dryer Class
 */
class Dryer(id:Int,
            reservations: Reservations): AbstractMachine(id
                                                        ,nCost = 4.50f,
                                                        nRunTime = LocalTime.of(0,50),
                                                        nLoadSize = 3, reservations)