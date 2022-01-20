package br.com.ezequiel.travels.service.travel.model

import br.com.ezequiel.travels.repository.entity.TravelStatus
import java.util.UUID

data class SingleTravelRequestModel(

    val id: UUID,
    val origin: String,
    val destination: String,
    val passenger: PassengerTravelRequestModel,
    val status: TravelStatus,
    val driver: DriverTravelRequestModel?

)
