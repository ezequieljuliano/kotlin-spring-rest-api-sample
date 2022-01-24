package br.com.ezequiel.travels.entrypoint.passenger.response

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class PassengerResponse(

    @field:Schema(description = "Passenger identifier")
    val id: UUID,

    @field:Schema(description = "Passenger name")
    val name: String

)
