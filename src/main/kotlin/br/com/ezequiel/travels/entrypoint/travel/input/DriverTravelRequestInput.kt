package br.com.ezequiel.travels.entrypoint.travel.input

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class DriverTravelRequestInput(

    @field:Schema(description = "Driver identifier")
    val driverId: UUID

)
