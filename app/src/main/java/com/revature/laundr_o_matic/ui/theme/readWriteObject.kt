package com.revature.laundr_o_matic.ui.theme


import android.content.Context
import android.util.Log
import com.revature.laundr_o_matic.User
import com.revature.laundr_o_matic.model.MachineManager
import com.revature.laundr_o_matic.utility.Constants
import java.io.*

fun writeMachines(machines:MachineManager){
    val fileExists = File(Constants.FILEPATH_MACHINES)
    var filePath = Constants.FILEPATH_MACHINES
    if (!fileExists.exists()){
        fileExists.createNewFile()
    }

    val file = FileOutputStream(filePath)
    val outStream = ObjectOutputStream(file)

    outStream.writeObject(machines)
    outStream.close()
    file.close()
}

fun readMachines(filePath: String):MachineManager{

    if (!File(filePath).exists()){
        val machines = MachineManager()
        writeMachines(machines)
        return machines
    }

    val file = FileInputStream(filePath)
    val inStream = ObjectInputStream(file)
    val machines = inStream.readObject() as MachineManager

    inStream.close()
    file.close()
    return machines
}

fun writeToFile(context:Context,user: User){
    var filePath = "${context.getFilesDir().toString()}/${user.username}.ser"
    val fileExist =  File(filePath)
    if (!fileExist.exists())
    {
        fileExist.createNewFile()
    }
    val file = FileOutputStream(filePath)

    val outStream = ObjectOutputStream(file)

    // Method for serialization of object
    outStream.writeObject(user)

    outStream.close()
    file.close()
}

fun readFromFile(filePath: String):User{
    val file = FileInputStream(filePath)
    val inStream = ObjectInputStream(file)

    // Method for deserialization of object
    val myAccount = inStream.readObject() as User

    inStream.close()
    file.close()
    return myAccount
}

