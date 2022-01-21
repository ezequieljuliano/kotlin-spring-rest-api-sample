package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.output.PassengerOutput
import br.com.ezequiel.travels.service.passenger.model.Passenger

fun Passenger.toOutput() = PassengerOutput(

    id = id,
    name = name

)