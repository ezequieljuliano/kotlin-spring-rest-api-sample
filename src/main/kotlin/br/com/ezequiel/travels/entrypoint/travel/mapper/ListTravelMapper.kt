package br.com.ezequiel.travels.entrypoint.travel.mapper

import br.com.ezequiel.travels.entrypoint.travel.response.TravelPassengerResponse
import br.com.ezequiel.travels.entrypoint.travel.response.TravelResponse
import br.com.ezequiel.travels.service.travel.model.Travel

fun Travel.toOutput() = TravelResponse(

    id = id,
    origin = origin,
    destination = destination,
    passenger = TravelPassengerResponse(passenger.id, passenger.name)

)