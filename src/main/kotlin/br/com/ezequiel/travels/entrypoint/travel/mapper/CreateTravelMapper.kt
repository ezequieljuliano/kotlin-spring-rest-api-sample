package br.com.ezequiel.travels.entrypoint.travel.mapper

import br.com.ezequiel.travels.entrypoint.travel.input.TravelToCreateInput
import br.com.ezequiel.travels.service.travel.model.TravelToCreate

fun TravelToCreateInput.toModel() = TravelToCreate(

    origin = origin,
    destination = destination,
    passengerId = passengerId

)