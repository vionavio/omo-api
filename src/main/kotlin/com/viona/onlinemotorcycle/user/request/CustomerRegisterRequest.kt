package com.viona.onlinemotorcycle.user.request

import com.viona.onlinemotorcycle.user.entity.User

data class CustomerRegisterRequest(
    val username: String,
    val password: String
) {
    fun mapToUser(): User {
        return User.createNewUser(username, password)
    }
}