package com.viona.onlinemotorcycle.customer.entity

import java.util.*


data class Customer(
    var id: String ="",
    var username: String = "",
    var password: String? = ""
) {
    companion object {
        fun createNewCustomer(username: String, password: String): Customer {
            return Customer(
                id = UUID.randomUUID().toString(),
                username = username,
                password = password
            )
        }
    }
}