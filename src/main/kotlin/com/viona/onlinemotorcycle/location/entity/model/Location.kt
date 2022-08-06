package com.viona.onlinemotorcycle.location.entity.model

data class Location(
    val name: String = "",
    val address: Address? = null,
    val coordinate: Coordinate? = null
)
