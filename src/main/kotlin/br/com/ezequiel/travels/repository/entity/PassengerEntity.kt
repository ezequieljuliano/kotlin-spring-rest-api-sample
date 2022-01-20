package br.com.ezequiel.travels.repository.entity

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(name = "passenger")
data class PassengerEntity(

    @field:Id
    @field:GeneratedValue
    @field:Column(columnDefinition = "uuid", name = "psg_id", updatable = false)
    val id: UUID = UUID.randomUUID(),

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Column(name = "psg_name")
    val name: String

)
