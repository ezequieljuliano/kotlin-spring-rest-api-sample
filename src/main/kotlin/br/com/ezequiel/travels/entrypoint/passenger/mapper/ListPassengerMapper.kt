package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.response.PassengerResponse
import br.com.ezequiel.travels.service.passenger.model.Passenger

fun Passenger.toOutput() = PassengerResponse(
    id = id,
    name = name
)