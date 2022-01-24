package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.response.DriverResponse
import br.com.ezequiel.travels.service.driver.model.Driver

fun Driver.toOutput() = DriverResponse(

    id = id,
    name = name,
    birthdate = birthdate

)