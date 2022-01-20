package br.com.ezequiel.travels.service.passenger.mapper

import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.service.passenger.model.CreatePassengerModel

fun CreatePassengerModel.toEntity() = PassengerEntity(

    name = name

)