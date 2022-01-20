package br.com.ezequiel.travels.service.travel.mapper

import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.service.travel.model.CreateTravelRequestModel

fun CreateTravelRequestModel.toEntity(passenger: PassengerEntity) = TravelEntity(

    origin = origin,
    destination = destination,
    passenger = passenger

)