package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.output.DriverOutput
import br.com.ezequiel.travels.service.driver.model.Driver

fun Driver.toOutput() = DriverOutput(

    id = id,
    name = name,
    birthdate = birthdate

)