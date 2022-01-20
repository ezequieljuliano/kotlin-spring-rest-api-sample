package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.input.CreatePassengerInput
import br.com.ezequiel.travels.service.passenger.model.CreatePassengerModel

fun CreatePassengerInput.toModel() = CreatePassengerModel(

    name = name

)