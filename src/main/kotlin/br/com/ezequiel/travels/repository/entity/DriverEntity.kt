package br.com.ezequiel.travels.repository.entity

import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@Entity
@Table(name = "driver")
data class DriverEntity(

    @field:Id
    @field:GeneratedValue
    @field:Column(columnDefinition = "uuid", name = "drv_id", updatable = false)
    val id: UUID?,

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Column(name = "drv_name")
    val name: String,

    @field:NotNull
    @field:Past
    @field:Column(name = "drv_birthdate")
    val birthdate: LocalDate

)
