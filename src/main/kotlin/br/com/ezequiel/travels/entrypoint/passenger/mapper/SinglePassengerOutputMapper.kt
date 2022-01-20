package br.com.ezequiel.travels.entrypoint.passenger.mapper

import br.com.ezequiel.travels.entrypoint.passenger.output.SinglePassengerOutput
import br.com.ezequiel.travels.service.passenger.model.SinglePassengerModel

fun SinglePassengerModel.toOutput() = SinglePassengerOutput(

    id = id,
    name = name

)