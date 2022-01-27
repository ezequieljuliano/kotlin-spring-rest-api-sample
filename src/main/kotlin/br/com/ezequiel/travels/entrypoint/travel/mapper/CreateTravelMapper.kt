package br.com.ezequiel.travels.entrypoint.travel.mapper

import br.com.ezequiel.travels.entrypoint.travel.request.TravelToCreateRequest
import br.com.ezequiel.travels.service.travel.model.TravelToCreate

fun TravelToCreateRequest.toModel() = TravelToCreate(
    origin = origin,
    destination = destination,
    passengerId = passengerId
)