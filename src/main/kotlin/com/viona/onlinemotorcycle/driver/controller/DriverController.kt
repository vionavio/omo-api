package com.viona.onlinemotorcycle.driver.controller

import com.viona.onlinemotorcycle.base.BaseResponse
import com.viona.onlinemotorcycle.driver.entity.Driver
import com.viona.onlinemotorcycle.driver.entity.DriverLogin
import com.viona.onlinemotorcycle.driver.entity.DriverLoginResponse
import com.viona.onlinemotorcycle.driver.entity.DriverRequest
import com.viona.onlinemotorcycle.driver.service.DriverService
import com.viona.onlinemotorcycle.utils.toResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/driver")
class DriverController {
    @Autowired
    private lateinit var driverService: DriverService

    @GetMapping
    fun getUser(): BaseResponse<Driver> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return driverService.getDriverByDriverId(userId.orEmpty()).toResponses()
    }

    @PostMapping("/login")
    fun login(
        @RequestBody driverLogin: DriverLogin
    ): BaseResponse<DriverLoginResponse> {
        return driverService.login(driverLogin).toResponses()
    }

    @PostMapping("/register")
    fun register(
        @RequestBody driverRequest: DriverRequest
    ): BaseResponse<Boolean> {
        return driverService.register(driverRequest.mapToNewDriver()).toResponses()
    }

}