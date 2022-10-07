package com.viona.onlinemotorcycle.user.service

import com.viona.onlinemotorcycle.user.entity.LoginResponse
import com.viona.onlinemotorcycle.user.entity.User
import com.viona.onlinemotorcycle.user.entity.UserLogin

interface UserService {

    fun login(userLogin: UserLogin): Result<LoginResponse>
    fun register(user: User): Result<Boolean>
    fun getUserByUserId(id: String): Result<User>
    fun getUserByUsername(username: String): Result<User>
}