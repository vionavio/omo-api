package com.viona.onlinemotorcycle.customer.repository

import com.mongodb.client.MongoCollection
import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.customer.entity.location.CustomerLocation
import com.viona.onlinemotorcycle.database.DatabaseComponent
import com.viona.onlinemotorcycle.exception.OjolException
import com.viona.onlinemotorcycle.utils.toResult
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryImpl(
    @Autowired
    private val databaseComponent: DatabaseComponent
) : CustomerRepository {

    private fun getCollection(): MongoCollection<Customer> =
        databaseComponent.database.getDatabase("omo").getCollection()

    private fun getCollectionLocation(): MongoCollection<CustomerLocation> =
        databaseComponent.database.getDatabase("omo").getCollection()

    override fun insertCustomer(customer: Customer): Result<Boolean> {
        val existingUser = getCustomerByUsername(customer.username)
        return if (existingUser.isSuccess) {
            throw OjolException("user exist!")
        } else getCollection().insertOne(customer).wasAcknowledged().toResult()
    }

    override fun getCustomerById(id: String): Result<Customer> =
        getCollection().findOne(Customer::id eq id).toResult()

    override fun getCustomerByUsername(username: String): Result<Customer> =
        getCollection().findOne(Customer::username eq username).toResult("user with $username not found")

    override fun insertCustomerSearchLocation(searchLocation: CustomerLocation): Result<CustomerLocation> {
        val existingUser = getCustomerById(searchLocation.idUser)
        if (existingUser.isSuccess) {
            getCollectionLocation().insertOne(searchLocation).wasAcknowledged().toResult()
            return getCollectionLocation().findOne(CustomerLocation::idLocation eq searchLocation.idLocation).toResult()
        } else throw OjolException("User doesnt exist")
    }

    override fun insertCustomerReverseLocation(searchLocation: CustomerLocation): Result<CustomerLocation> {
        val existingUser = getCustomerById(searchLocation.idUser)
        if (existingUser.isSuccess) {
            getCollectionLocation().insertOne(searchLocation).wasAcknowledged().toResult()
            return getCollectionLocation().findOne(CustomerLocation::idLocation eq searchLocation.idLocation).toResult()
        } else throw OjolException("User doesnt exist")
    }

}