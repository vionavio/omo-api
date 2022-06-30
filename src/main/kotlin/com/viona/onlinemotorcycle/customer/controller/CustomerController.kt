package com.viona.onlinemotorcycle.customer.controller

import com.viona.onlinemotorcycle.base.BaseResponse
import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.customer.entity.CustomerLogin
import com.viona.onlinemotorcycle.customer.entity.CustomerRequest
import com.viona.onlinemotorcycle.customer.entity.LoginResponse
import com.viona.onlinemotorcycle.customer.service.CustomerService
import com.viona.onlinemotorcycle.utils.toResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping
    fun getCustomer(): BaseResponse<Customer> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return customerService.getCustomerByCustomerId(userId.orEmpty()).toResponses()
    }

    @PostMapping("/login")
    fun login(
        @RequestBody userLogin: CustomerLogin
    ): BaseResponse<LoginResponse> {
        return customerService.login(userLogin).toResponses()
    }

    @PostMapping("/register")
    fun register(
        @RequestBody userRequest: CustomerRequest
    ): BaseResponse<Boolean> {
        return customerService.register(userRequest.mapToNewCustomer()).toResponses()
    }
}