package com.revature.laundr_o_matic

import com.revature.laundr_o_matic.model.UserReservations
import java.io.Serializable

data class User (
    val username:String,
    val password:String,
    val reservations:UserReservations = UserReservations()
) :Serializable
