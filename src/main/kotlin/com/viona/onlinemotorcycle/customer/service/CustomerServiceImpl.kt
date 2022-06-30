package com.viona.onlinemotorcycle.customer.service

import com.viona.onlinemotorcycle.authentication.JwtConfig
import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.customer.entity.CustomerLogin
import com.viona.onlinemotorcycle.customer.entity.LoginResponse
import com.viona.onlinemotorcycle.customer.repository.CustomerRepository
import com.viona.onlinemotorcycle.exception.OjolException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CustomerServiceImpl(
    @Autowired
    private val customerRepository: CustomerRepository
): CustomerService {
    override fun login(userLogin: CustomerLogin): Result<LoginResponse> {
        val resultUser = customerRepository.getCustomerByUsername(userLogin.username)
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

    override fun register(customer: Customer): Result<Boolean> =
        customerRepository.insertCustomer(customer)

    override fun getCustomerByCustomerId(id: String): Result<Customer> {
        return customerRepository.getCustomerById(id).map {
            it.password = null
            it
        }
    }

    override fun getCustomerByUsername(username: String): Result<Customer> {
        return customerRepository.getCustomerByUsername(username).map {
            it.password = null
            it
        }
    }

}