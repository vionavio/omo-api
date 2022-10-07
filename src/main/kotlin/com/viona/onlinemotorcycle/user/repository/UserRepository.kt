package com.viona.onlinemotorcycle.user.repository

import com.viona.onlinemotorcycle.user.entity.User


interface UserRepository {

    fun insertUser(customer: User): Result<Boolean>

    fun getUserById(id: String): Result<User>

    fun getUserByUsername(username: String): Result<User>

}