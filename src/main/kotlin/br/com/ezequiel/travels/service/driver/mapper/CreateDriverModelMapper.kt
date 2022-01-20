package br.com.ezequiel.travels.service.driver.mapper

import br.com.ezequiel.travels.repository.entity.DriverEntity
import br.com.ezequiel.travels.service.driver.model.CreateDriverModel

fun CreateDriverModel.toEntity() = DriverEntity(

    name = name,
    birthdate = birthdate

)