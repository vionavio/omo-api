package com.viona.onlinemotorcycle.customer.repository

import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.customer.entity.location.CustomerLocation

interface CustomerRepository {

    fun insertCustomer(customer: Customer): Result<Boolean>

    fun getCustomerById(id: String): Result<Customer>

    fun getCustomerByUsername(username: String): Result<Customer>

    fun insertCustomerSearchLocation(searchLocation: CustomerLocation): Result<CustomerLocation>
}