package com.viona.onlinemotorcycle.customer.service

import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.customer.entity.CustomerLogin
import com.viona.onlinemotorcycle.customer.entity.LoginResponse
import com.viona.onlinemotorcycle.customer.entity.location.CustomerLocation
import com.viona.onlinemotorcycle.location.entity.model.Coordinate
import com.viona.onlinemotorcycle.location.entity.model.Location

interface CustomerService {

    fun login(userLogin: CustomerLogin): Result<LoginResponse>
    fun register(user: Customer): Result<Boolean>
    fun getCustomerByCustomerId(id: String): Result<Customer>
    fun getCustomerByUsername(username: String): Result<Customer>

    fun searchLocation(id: String, name: String, coordinate: Coordinate): Result<List<Location>>?
    fun insertSearchLocation(userId: String, name: String, coordinate: Coordinate): Result<CustomerLocation>

}