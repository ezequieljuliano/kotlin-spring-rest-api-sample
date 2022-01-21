package br.com.ezequiel.travels.service.travel.model

import java.util.UUID

data class TravelToCreate(

    val origin: String,
    val destination: String,
    val passengerId: UUID

)
