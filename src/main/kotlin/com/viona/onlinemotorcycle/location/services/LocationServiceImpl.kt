package com.viona.onlinemotorcycle.location.services

import com.viona.onlinemotorcycle.location.component.LocationComponent
import com.viona.onlinemotorcycle.location.entity.model.Coordinate
import com.viona.onlinemotorcycle.location.entity.model.Location
import com.viona.onlinemotorcycle.location.entity.model.Routes
import com.viona.onlinemotorcycle.location.mapper.LocationMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocationServiceImpl(
    @Autowired
    private val fetcher: LocationComponent
): LocationService {
    override fun searchLocation(name: String, coordinate: Coordinate): Result<List<Location>> {
        return fetcher.searchLocation(name, coordinate).map {
            LocationMapper.mapLocationHereToLocation(it)
        }
    }

    override fun reserveLocation(coordinate: Coordinate): Result<List<Location>> {
        return fetcher.reserveLocation(coordinate).map {
            LocationMapper.mapLocationHereToLocation(it)
        }
    }

    override fun getRoutesLocation(origin: Coordinate, destination: Coordinate): Result<Routes> {
        return fetcher.getRoutes(origin, destination).map {
            Routes(LocationMapper.mapRoutesHereToRoutes(it))
        }
    }

}