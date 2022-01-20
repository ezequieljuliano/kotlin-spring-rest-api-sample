package br.com.ezequiel.travels.repository.entity

import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
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
    val id: UUID = UUID.randomUUID(),

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Column(name = "drv_name")
    val name: String,

    @field:NotNull
    @field:Past
    @field:Column(name = "drv_birthdate")
    val birthdate: LocalDate

)