package br.com.ezequiel.travels.entrypoint.driver.response

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.util.UUID

data class DriverResponse(

    @field:Schema(description = "Driver identifier")
    val id: UUID,

    @field:Schema(description = "Driver name")
    val name: String,

    @field:Schema(description = "Driver birthdate")
    val birthdate: LocalDate

)
