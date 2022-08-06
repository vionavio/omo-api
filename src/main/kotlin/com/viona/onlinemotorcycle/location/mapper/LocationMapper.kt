package com.viona.onlinemotorcycle.location.mapper

import com.viona.onlinemotorcycle.location.entity.model.Address
import com.viona.onlinemotorcycle.location.entity.model.Coordinate
import com.viona.onlinemotorcycle.location.entity.model.Location
import com.viona.onlinemotorcycle.location.entity.response.LocationHereResponse
import com.viona.onlinemotorcycle.location.entity.response.LocationHereRouteResponse
import com.viona.onlinemotorcycle.location.util.PolylineEncoderDecoder

object LocationMapper {

    fun mapLocationHereToLocation(locationSearchResult: LocationHereResponse): List<Location> {
        return locationSearchResult.items?.map {
            val address = Address(
                city = it?.address?.city.orEmpty(),
                country = it?.address?.countryName.orEmpty(),
                district = it?.address?.district.orEmpty()
            )
            Location(
                name = it?.title.orEmpty(),
                address = address,
                coordinate = Coordinate(it?.position?.lat ?: 0.0, it?.position?.lng ?: 0.0)
            )
        }.orEmpty()
    }

    fun mapRoutesHereToRoutes(locationResult: LocationHereRouteResponse): List<Coordinate> {
        val polylineString = locationResult.routes
            ?.firstOrNull()
            ?.sections
            ?.firstOrNull()
            ?.polyline.orEmpty()

        return PolylineEncoderDecoder.decode(polylineString)
            .map { Coordinate(it.lat, it.lng) }
    }

}