package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.input.PassengerToCreateInput
import br.com.ezequiel.travels.service.passenger.model.PassengerToCreate

fun PassengerToCreateInput.toModel() = PassengerToCreate(

    name = name

)