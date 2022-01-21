package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.input.PassengerToUpdateInput
import br.com.ezequiel.travels.service.passenger.model.PassengerToUpdate
import java.util.UUID

fun PassengerToUpdateInput.toModel(id: UUID) = PassengerToUpdate(

    id = id,
    name = name

)