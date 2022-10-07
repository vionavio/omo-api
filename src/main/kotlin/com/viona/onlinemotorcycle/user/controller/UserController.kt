package com.viona.onlinemotorcycle.user.controller

import com.viona.onlinemotorcycle.base.BaseResponse
import com.viona.onlinemotorcycle.user.entity.LoginResponse
import com.viona.onlinemotorcycle.user.entity.User
import com.viona.onlinemotorcycle.user.entity.UserLogin
import com.viona.onlinemotorcycle.user.request.CustomerRegisterRequest
import com.viona.onlinemotorcycle.user.request.DriverRegisterRequest
import com.viona.onlinemotorcycle.user.service.UserService
import com.viona.onlinemotorcycle.utils.toResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUser(): BaseResponse<User> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return userService.getUserByUserId(userId.orEmpty()).toResponses()
    }

    @PostMapping("/login")
    fun login(
        @RequestBody userLogin: UserLogin
    ): BaseResponse<LoginResponse> {
        return userService.login(userLogin).toResponses()
    }

    @PostMapping("customer/register")
    fun register(
        @RequestBody userRequest: CustomerRegisterRequest
    ): BaseResponse<Boolean> {
        val user = userRequest.mapToUser()
        return userService.register(user).toResponses()
    }

    @PostMapping("/driver/register")
    fun registerDriver(
        @RequestBody userRequest: DriverRegisterRequest
    ): BaseResponse<Boolean>{
        val user = userRequest.mapToUser()
        return userService.register(user).toResponses()
    }
}