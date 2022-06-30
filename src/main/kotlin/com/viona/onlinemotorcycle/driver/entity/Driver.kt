package com.viona.onlinemotorcycle.driver.entity

import java.util.*


data class Driver(
    var id: String = "",
    var username: String = "",
    var password: String? = "",
    var vehicleType: String? = "",
    var vehicleRegistNumber: String? = ""
) {
    companion object {
        fun createNewDriver(
            username: String,
            password: String,
            vehicleType: String?,
            vehicleRegistNumber: String?
        ): Driver {
            return Driver(
                id = UUID.randomUUID().toString(),
                username = username,
                password = password,
                vehicleType = vehicleType,
                vehicleRegistNumber = vehicleRegistNumber
            )
        }
    }
}