package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.input.UpdatePassengerInput
import br.com.ezequiel.travels.service.passenger.model.UpdatePassengerModel
import java.util.UUID

fun UpdatePassengerInput.toModel(id: UUID) = UpdatePassengerModel(

    id = id,
    name = name

)