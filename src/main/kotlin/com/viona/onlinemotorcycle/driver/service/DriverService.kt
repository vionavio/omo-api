package com.viona.onlinemotorcycle.driver.service

import com.viona.onlinemotorcycle.driver.entity.Driver
import com.viona.onlinemotorcycle.driver.entity.DriverLogin
import com.viona.onlinemotorcycle.driver.entity.DriverLoginResponse


interface DriverService {
    fun login(userLogin: DriverLogin): Result<DriverLoginResponse>
    fun register(user: Driver): Result<Boolean>
    fun getDriverByDriverId(id: String): Result<Driver>
    fun getDriverByUsername(username: String): Result<Driver>
}