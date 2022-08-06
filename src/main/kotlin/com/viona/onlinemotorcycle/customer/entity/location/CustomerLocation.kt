package com.viona.onlinemotorcycle.customer.entity.location

import com.viona.onlinemotorcycle.location.entity.model.Location
import java.util.*

data class CustomerLocation(
    val idLocation: String = "",
    val idUser: String = "",
    val location: List<Location>? = null
) {

        fun createNewLocation(userId: String, location: List<Location>): CustomerLocation {
            return CustomerLocation(
                idLocation = UUID.randomUUID().toString(),
                idUser = userId,
                location = location
            )
        }

}