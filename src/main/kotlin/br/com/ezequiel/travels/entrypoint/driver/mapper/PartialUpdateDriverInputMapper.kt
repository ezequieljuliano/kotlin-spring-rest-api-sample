package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.input.PartialUpdateDriverInput
import br.com.ezequiel.travels.service.driver.model.PartialUpdateDriverModel
import java.util.UUID

fun PartialUpdateDriverInput.toModel(id: UUID) = PartialUpdateDriverModel(

    id = id,
    name = name,
    birthdate = birthdate

)