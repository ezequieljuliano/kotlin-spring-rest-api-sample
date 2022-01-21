package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.input.DriverToCreateInput
import br.com.ezequiel.travels.service.driver.model.DriverToCreate

fun DriverToCreateInput.toModel() = DriverToCreate(

    name = name,
    birthdate = birthdate

)