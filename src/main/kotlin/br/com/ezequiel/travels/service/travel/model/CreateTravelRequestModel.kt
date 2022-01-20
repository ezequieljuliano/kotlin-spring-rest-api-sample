package br.com.ezequiel.travels.service.travel.model

import java.util.UUID

data class CreateTravelRequestModel(

    val origin: String,
    val destination: String,
    val passengerId: UUID

)
