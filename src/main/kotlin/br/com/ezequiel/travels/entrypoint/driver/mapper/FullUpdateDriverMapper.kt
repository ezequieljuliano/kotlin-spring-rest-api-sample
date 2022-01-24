package br.com.ezequiel.travels.entrypoint.driver.mapper

import br.com.ezequiel.travels.entrypoint.driver.request.DriverToFullUpdateRequest
import br.com.ezequiel.travels.service.driver.model.DriverToFullUpdate
import java.util.*

fun DriverToFullUpdateRequest.toModel(id: UUID) = DriverToFullUpdate(

    id = id,
    name = name,
    birthdate = birthdate

)