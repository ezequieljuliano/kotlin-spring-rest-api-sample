package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.input.CreateDriverInput
import br.com.ezequiel.travels.service.driver.model.CreateDriverModel

fun CreateDriverInput.toModel() = CreateDriverModel(

    name = name,
    birthdate = birthdate

)