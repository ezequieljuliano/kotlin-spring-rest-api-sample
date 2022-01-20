package br.com.ezequiel.travels.service.travel.mapper

import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.service.travel.model.DriverTravelRequestModel
import br.com.ezequiel.travels.service.travel.model.PassengerTravelRequestModel
import br.com.ezequiel.travels.service.travel.model.SingleTravelRequestModel

fun TravelEntity.toModel() = SingleTravelRequestModel(

    id = id,
    origin = origin,
    destination = destination,
    passenger = PassengerTravelRequestModel(passenger.id, passenger.name),
    status = status,
    driver = driver?.let { DriverTravelRequestModel(it.id, it.name) }

)