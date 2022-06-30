package com.viona.onlinemotorcycle.driver.service

import com.viona.onlinemotorcycle.authentication.JwtConfig
import com.viona.onlinemotorcycle.customer.entity.LoginResponse
import com.viona.onlinemotorcycle.driver.entity.Driver
import com.viona.onlinemotorcycle.driver.entity.DriverLogin
import com.viona.onlinemotorcycle.driver.entity.DriverLoginResponse
import com.viona.onlinemotorcycle.driver.repository.DriverRepository
import com.viona.onlinemotorcycle.exception.OjolException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DriverServiceImpl(
    @Autowired
    private val driverRepository: DriverRepository
) : DriverService {
    override fun login(userLogin: DriverLogin): Result<DriverLoginResponse> {
        val resultUser = driverRepository.getDriverByUsername(userLogin.username)
        return resultUser.map {
            val token = JwtConfig.generateTokenDriver(it)
            val passwordInDb = it.password
            val passwordRequest = userLogin.password
            if (passwordInDb == passwordRequest) {
                DriverLoginResponse(token)
            } else {
                throw OjolException("Password invalid")
            }
        }
    }

    override fun register(driver: Driver): Result<Boolean> {
        return driverRepository.insertDriver(driver)
    }

    override fun getDriverByDriverId(id: String): Result<Driver> {
        return driverRepository.getDriverById(id).map {
            it.password = null
            it
        }
    }

    override fun getDriverByUsername(username: String): Result<Driver> {
        return driverRepository.getDriverByUsername(username).map {
            it.password = null
            it
        }
    }
}