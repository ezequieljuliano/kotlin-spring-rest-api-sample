package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.request.DriverToCreateRequest
import br.com.ezequiel.travels.service.driver.model.DriverToCreate

fun DriverToCreateRequest.toModel() = DriverToCreate(
    name = name,
    birthdate = birthdate
)