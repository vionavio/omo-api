package com.viona.onlinemotorcycle.user.service

import com.viona.onlinemotorcycle.authentication.JwtConfig
import com.viona.onlinemotorcycle.user.repository.UserRepository
import com.viona.onlinemotorcycle.exception.OjolException
import com.viona.onlinemotorcycle.user.entity.LoginResponse
import com.viona.onlinemotorcycle.user.entity.User
import com.viona.onlinemotorcycle.user.entity.UserLogin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
    @Autowired
    private val userRepository: UserRepository
) : UserService {

    override fun login(userLogin: UserLogin): Result<LoginResponse> {
        val resultUser = userRepository.getUserByUsername(userLogin.username)
        return resultUser.map {
            val token = JwtConfig.generateToken(it)
            val passwordInDb = it.password
            val passwordRequest = userLogin.password
            if (passwordInDb == passwordRequest) {
                LoginResponse(token)
            } else {
                throw OjolException("Password invalid")
            }
        }
    }

    override fun register(user: User): Result<Boolean> =
        userRepository.insertUser(user)

    override fun getUserByUserId(id: String): Result<User> {
        return userRepository.getUserById(id).map {
            it.password = null
            it
        }
    }

    override fun getUserByUsername(username: String): Result<User> {
        return userRepository.getUserByUsername(username).map {
            it.password = null
            it
        }
    }
}