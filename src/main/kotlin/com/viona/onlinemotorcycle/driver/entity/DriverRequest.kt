package com.viona.onlinemotorcycle.driver.entity

data class DriverRequest(
    val username: String,
    val password: String,
    var vehicleType: String? = "",
    var vehicleRegistNumber: String? = ""
) {
    fun mapToNewDriver(): Driver {
        return Driver.createNewDriver(username, password, vehicleType, vehicleRegistNumber)
    }
}