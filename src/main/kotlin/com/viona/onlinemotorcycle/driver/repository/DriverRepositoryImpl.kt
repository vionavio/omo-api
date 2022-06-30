package com.viona.onlinemotorcycle.driver.repository

import com.mongodb.client.MongoCollection
import com.viona.onlinemotorcycle.customer.entity.Customer
import com.viona.onlinemotorcycle.database.DatabaseComponent
import com.viona.onlinemotorcycle.driver.entity.Driver
import com.viona.onlinemotorcycle.exception.OjolException
import com.viona.onlinemotorcycle.utils.toResult
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class DriverRepositoryImpl(
    @Autowired
    private val databaseComponent: DatabaseComponent
) : DriverRepository {
    private fun getCollection(): MongoCollection<Driver> =
        databaseComponent.database.getDatabase("omo").getCollection()

    override fun insertDriver(driver: Driver): Result<Boolean> {
        val existingUser = getDriverByUsername(driver.username)
        return if (existingUser.isSuccess) {
            throw OjolException("user exist!")
        } else getCollection().insertOne(driver).wasAcknowledged().toResult()
    }

    override fun getDriverById(id: String): Result<Driver> =
        getCollection().findOne(Driver::id eq id).toResult()

    override fun getDriverByUsername(username: String): Result<Driver> =
        getCollection().findOne(Customer::username eq username).toResult("user with $username not found")

}