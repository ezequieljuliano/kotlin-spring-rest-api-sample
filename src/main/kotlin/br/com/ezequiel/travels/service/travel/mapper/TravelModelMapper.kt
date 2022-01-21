package br.com.ezequiel.travels.service.travel.mapper

import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.service.travel.model.Travel
import br.com.ezequiel.travels.service.travel.model.TravelDriver
import br.com.ezequiel.travels.service.travel.model.TravelPassenger
import br.com.ezequiel.travels.service.travel.model.TravelToCreate

fun TravelToCreate.toEntity(passenger: PassengerEntity) = TravelEntity(

    origin = origin,
    destination = destination,
    passenger = passenger

)

fun TravelEntity.toModel() = Travel(

    id = id,
    origin = origin,
    destination = destination,
    passenger = TravelPassenger(passenger.id, passenger.name),
    status = status,
    driver = driver?.let { TravelDriver(it.id, it.name) }

)