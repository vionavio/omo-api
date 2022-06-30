package com.viona.onlinemotorcycle.driver.repository

import com.viona.onlinemotorcycle.driver.entity.Driver

interface DriverRepository {

    fun insertDriver(driver: Driver): Result<Boolean>

    fun getDriverById(id: String): Result<Driver>

    fun getDriverByUsername(username: String): Result<Driver>
}