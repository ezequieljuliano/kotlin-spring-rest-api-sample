package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.input.DriverToPartialUpdateInput
import br.com.ezequiel.travels.service.driver.model.DriverToPartialUpdate
import java.util.*

fun DriverToPartialUpdateInput.toModel(id: UUID) = DriverToPartialUpdate(

    id = id,
    name = name,
    birthdate = birthdate

)