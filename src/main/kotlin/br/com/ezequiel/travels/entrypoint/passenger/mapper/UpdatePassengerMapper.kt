package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.request.PassengerToUpdateRequest
import br.com.ezequiel.travels.service.passenger.model.PassengerToUpdate
import java.util.UUID

fun PassengerToUpdateRequest.toModel(id: UUID) = PassengerToUpdate(
    id = id,
    name = name
)