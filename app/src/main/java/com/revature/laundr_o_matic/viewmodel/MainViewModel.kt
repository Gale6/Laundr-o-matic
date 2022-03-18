package com.revature.laundr_o_matic.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.revature.laundr_o_matic.User
import com.revature.laundr_o_matic.model.AbstractMachine
import com.revature.laundr_o_matic.model.DateSlot
import com.revature.laundr_o_matic.model.MachineManager
import java.time.LocalDate
import java.time.LocalTime

class MainViewModel:ViewModel() {

    //Reservation Selection Variables
    var machineManager = MachineManager()
    lateinit var selectedMachine:AbstractMachine
    lateinit var selectedDate: MutableState<DateSlot>
    lateinit var selectedTime: LocalTime

    //User
    lateinit var user: User



}