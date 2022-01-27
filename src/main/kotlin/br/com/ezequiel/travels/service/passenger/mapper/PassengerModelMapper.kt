package br.com.ezequiel.travels.service.passenger.mapper

import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.service.passenger.model.Passenger
import br.com.ezequiel.travels.service.passenger.model.PassengerToCreate

fun PassengerToCreate.toEntity() = PassengerEntity(
    id = null,
    name = name
)

fun PassengerEntity.toModel() = Passenger(
    id = id!!,
    name = name
)