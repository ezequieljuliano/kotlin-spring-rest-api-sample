package br.com.ezequiel.travels.service.driver.mapper

import br.com.ezequiel.travels.repository.entity.DriverEntity
import br.com.ezequiel.travels.service.driver.model.SingleDriverModel

fun DriverEntity.toModel() = SingleDriverModel(

    id = id,
    name = name,
    birthdate = birthdate

)