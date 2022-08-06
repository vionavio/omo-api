package com.viona.onlinemotorcycle.customer.service

import com.viona.onlinemotorcycle.authentication.JwtConfig
import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.customer.entity.CustomerLogin
import com.viona.onlinemotorcycle.customer.entity.LoginResponse
import com.viona.onlinemotorcycle.customer.entity.location.CustomerLocation
import com.viona.onlinemotorcycle.customer.repository.CustomerRepository
import com.viona.onlinemotorcycle.exception.OjolException
import com.viona.onlinemotorcycle.location.component.LocationComponent
import com.viona.onlinemotorcycle.location.entity.model.Coordinate
import com.viona.onlinemotorcycle.location.entity.model.Location
import com.viona.onlinemotorcycle.location.mapper.LocationMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CustomerServiceImpl(
    @Autowired
    private val customerRepository: CustomerRepository,
    @Autowired
    private val fetcher: LocationComponent
) : CustomerService {
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

    override fun register(user: Customer): Result<Boolean> =
        customerRepository.insertCustomer(user)

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

    override fun searchLocation(id: String, name: String, coordinate: Coordinate): Result<List<Location>>? {

        return fetcher.searchLocation(name, coordinate).map {
            LocationMapper.mapLocationHereToLocation(it)
        }
    }

    override fun insertSearchLocation(userId: String, name: String, coordinate: Coordinate): Result<CustomerLocation> {
        val result = fetcher.searchLocation(name, coordinate).map {
            LocationMapper.mapLocationHereToLocation(it)
        }
        var result2 = listOf<Location>()
        result.map {
            result2 = it
        }

        if (result2.isEmpty()) {
            throw OjolException("result location is empty")
        } else {
            val customerLocation = CustomerLocation().createNewLocation(
                userId = userId,
                location = result2
            )
            return customerRepository.insertCustomerSearchLocation(customerLocation)
        }
    }

    override fun insertReverseLocation(userId: String, coordinate: Coordinate): Result<CustomerLocation> {
        val result = fetcher.reverseLocation(coordinate).map {
            LocationMapper.mapLocationHereToLocation(it)
        }

        var result2 = listOf<Location>()
        result.map {
            result2 = it
        }

        if (result2.isEmpty()) {
            throw OjolException("result location is empty")
        } else {
            val customerLocation = CustomerLocation().createNewLocation(
                userId = userId,
                location = result2
            )
            return customerRepository.insertCustomerReverseLocation(customerLocation)
        }
    }
}