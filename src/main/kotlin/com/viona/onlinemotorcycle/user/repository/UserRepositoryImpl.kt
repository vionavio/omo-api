package com.viona.onlinemotorcycle.user.repository

import com.mongodb.client.MongoCollection
import com.viona.onlinemotorcycle.database.DatabaseComponent
import com.viona.onlinemotorcycle.exception.OjolException
import com.viona.onlinemotorcycle.user.entity.Role
import com.viona.onlinemotorcycle.user.entity.User
import com.viona.onlinemotorcycle.user.entity.extra.CustomerExtras
import com.viona.onlinemotorcycle.user.entity.extra.DriverExtras
import com.viona.onlinemotorcycle.utils.safeCastTo
import com.viona.onlinemotorcycle.utils.toResult
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    @Autowired
    private val databaseComponent: DatabaseComponent
) : UserRepository {

    private fun getCollection(): MongoCollection<User> =
        databaseComponent.database.getDatabase("omo").getCollection()

    override fun insertUser(customer: User): Result<Boolean> {
        val existingUser = getUserByUsername(customer.username)
        return if (existingUser.isSuccess) {
            throw OjolException("user exist!")
        } else getCollection().insertOne(customer).wasAcknowledged().toResult()
    }

    override fun getUserById(id: String): Result<User> {
        return getCollection().findOne(User::id eq id).run {
            if (this?.role == Role.DRIVER) {
                this.extra.safeCastTo(DriverExtras::class.java)
            } else {
                this?.extra?.safeCastTo(CustomerExtras::class.java)
            }
            this
        }.toResult()
    }

    override fun getUserByUsername(username: String): Result<User> =
        getCollection().findOne(User::username eq username).toResult("user with $username not found")

}