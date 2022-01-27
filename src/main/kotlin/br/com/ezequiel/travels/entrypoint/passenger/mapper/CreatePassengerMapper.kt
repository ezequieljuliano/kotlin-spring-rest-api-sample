package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.request.PassengerToCreateRequest
import br.com.ezequiel.travels.service.passenger.model.PassengerToCreate

fun PassengerToCreateRequest.toModel() = PassengerToCreate(
    name = name
)