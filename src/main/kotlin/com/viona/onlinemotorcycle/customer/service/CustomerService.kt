package com.viona.onlinemotorcycle.customer.service

import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.customer.entity.CustomerLogin
import com.viona.onlinemotorcycle.customer.entity.LoginResponse

interface CustomerService {

    fun login(userLogin: CustomerLogin): Result<LoginResponse>
    fun register(user: Customer): Result<Boolean>
    fun getCustomerByCustomerId(id: String): Result<Customer>
    fun getCustomerByUsername(username: String): Result<Customer>

}