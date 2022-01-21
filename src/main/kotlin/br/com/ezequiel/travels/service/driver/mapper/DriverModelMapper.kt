package br.com.ezequiel.travels.service.driver.mapper

import br.com.ezequiel.travels.repository.entity.DriverEntity
import br.com.ezequiel.travels.service.driver.model.Driver
import br.com.ezequiel.travels.service.driver.model.DriverToCreate

fun DriverToCreate.toEntity() = DriverEntity(

    name = name,
    birthdate = birthdate

)

fun DriverEntity.toModel() = Driver(

    id = id,
    name = name,
    birthdate = birthdate

)