package br.com.ezequiel.travels.entrypoint.driver.input

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.validation.constraints.Past
import javax.validation.constraints.Size

data class DriverToPartialUpdateInput(

    @field:Size(min = 5, max = 255)
    @field:Schema(description = "Driver name")
    val name: String?,

    @field:Past
    @field:Schema(description = "Driver birthdate")
    val birthdate: LocalDate?

)
