package com.viona.onlinemotorcycle.location.services

import com.viona.onlinemotorcycle.location.entity.model.Coordinate
import com.viona.onlinemotorcycle.location.entity.model.Location
import com.viona.onlinemotorcycle.location.entity.model.Routes

interface LocationService {
    fun searchLocation(name: String, coordinate: Coordinate): Result<List<Location>>
    fun reserveLocation(coordinate: Coordinate): Result<List<Location>>
    fun getRoutesLocation(origin: Coordinate, destination: Coordinate): Result<Routes>
}