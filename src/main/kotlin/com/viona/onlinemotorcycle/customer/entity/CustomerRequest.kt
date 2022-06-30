package com.viona.onlinemotorcycle.customer.entity

data class CustomerRequest(
    val username: String,
    val password: String
) {
    fun mapToNewCustomer(): Customer {
        return Customer.createNewCustomer(username, password)
    }
}