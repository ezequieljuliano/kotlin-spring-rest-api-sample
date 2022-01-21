package br.com.ezequiel.travels.service.travel.model

import br.com.ezequiel.travels.repository.entity.TravelStatusEnum
import java.util.UUID

data class Travel(

    val id: UUID,
    val origin: String,
    val destination: String,
    val passenger: TravelPassenger,
    val status: TravelStatusEnum,
    val driver: TravelDriver?

)
