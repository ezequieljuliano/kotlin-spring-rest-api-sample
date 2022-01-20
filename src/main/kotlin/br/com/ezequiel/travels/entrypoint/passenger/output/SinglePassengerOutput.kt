package br.com.ezequiel.travels.entrypoint.passenger.output

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class SinglePassengerOutput(

    @field:Schema(description = "Passenger identifier")
    val id: UUID,

    @field:Schema(description = "Passenger name")
    val name: String

)
