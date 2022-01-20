package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.input.FullUpdateDriverInput
import br.com.ezequiel.travels.service.driver.model.FullUpdateDriverModel
import java.util.UUID

fun FullUpdateDriverInput.toModel(id: UUID) = FullUpdateDriverModel(

    id = id,
    name = name,
    birthdate = birthdate

)