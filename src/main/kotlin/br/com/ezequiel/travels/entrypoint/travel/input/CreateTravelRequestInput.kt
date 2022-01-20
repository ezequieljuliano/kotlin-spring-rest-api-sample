package br.com.ezequiel.travels.entrypoint.travel.input

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateTravelRequestInput(

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Schema(description = "Travel request origin")
    val origin: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Schema(description = "Travel request destination")
    val destination: String,

    @field:NotNull
    @field:Schema(description = "Travel request passenger identifier")
    val passengerId: UUID

)
