package br.com.ezequiel.travels.entrypoint.travel.mapper

import br.com.ezequiel.travels.entrypoint.travel.output.PassengerTravelRequestOutput
import br.com.ezequiel.travels.entrypoint.travel.output.SingleTravelRequestOutput
import br.com.ezequiel.travels.service.travel.model.SingleTravelRequestModel

fun SingleTravelRequestModel.toOutput() = SingleTravelRequestOutput(

    id = id,
    origin = origin,
    destination = destination,
    passenger = PassengerTravelRequestOutput(passenger.id, passenger.name)

)