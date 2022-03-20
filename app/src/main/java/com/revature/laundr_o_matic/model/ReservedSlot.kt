package com.revature.laundr_o_matic.model

import java.io.Serializable
import java.time.LocalDateTime

data class ReservedSlot( var reservationTime:LocalDateTime,
                         var machine:AbstractMachine): Serializable