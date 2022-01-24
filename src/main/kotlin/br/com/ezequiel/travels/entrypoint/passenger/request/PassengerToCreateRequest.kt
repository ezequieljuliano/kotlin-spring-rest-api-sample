package br.com.ezequiel.travels.entrypoint.passenger.request

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class PassengerToCreateRequest(

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Schema(description = "Passenger name")
    val name: String

)
