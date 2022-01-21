package br.com.ezequiel.travels.entrypoint.travel.mapper

import br.com.ezequiel.travels.entrypoint.travel.output.TravelPassengerOutput
import br.com.ezequiel.travels.entrypoint.travel.output.TravelOutput
import br.com.ezequiel.travels.service.travel.model.Travel

fun Travel.toOutput() = TravelOutput(

    id = id,
    origin = origin,
    destination = destination,
    passenger = TravelPassengerOutput(passenger.id, passenger.name)

)