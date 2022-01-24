package br.com.ezequiel.travels.entrypoint.travel.response

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class TravelResponse(

    @field:Schema(description = "Travel request identifier")
    val id: UUID,

    @field:Schema(description = "Travel request origin")
    val origin: String,

    @field:Schema(description = "Travel request destination")
    val destination: String,

    @field:Schema(description = "Travel request passenger")
    val passenger: TravelPassengerResponse

)
