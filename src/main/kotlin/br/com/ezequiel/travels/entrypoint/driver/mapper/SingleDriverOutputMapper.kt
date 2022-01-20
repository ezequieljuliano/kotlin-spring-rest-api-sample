package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.output.SingleDriverOutput
import br.com.ezequiel.travels.service.driver.model.SingleDriverModel

fun SingleDriverModel.toOutput() = SingleDriverOutput(

    id = id,
    name = name,
    birthdate = birthdate

)