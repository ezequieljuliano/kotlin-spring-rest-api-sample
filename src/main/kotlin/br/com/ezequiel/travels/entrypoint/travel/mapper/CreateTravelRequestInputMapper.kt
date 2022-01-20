package br.com.ezequiel.travels.entrypoint.travel.mapper

import br.com.ezequiel.travels.entrypoint.travel.input.CreateTravelRequestInput
import br.com.ezequiel.travels.service.travel.model.CreateTravelRequestModel

fun CreateTravelRequestInput.toModel() = CreateTravelRequestModel(

    origin = origin,
    destination = destination,
    passengerId = passengerId

)