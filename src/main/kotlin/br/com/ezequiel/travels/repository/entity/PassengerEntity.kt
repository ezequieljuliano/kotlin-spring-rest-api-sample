package br.com.ezequiel.travels.repository.entity

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(name = "passenger")
data class PassengerEntity(

    @field:Id
    @field:GeneratedValue
    @field:Column(columnDefinition = "uuid", name = "psg_id", updatable = false)
    val id: UUID?,

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Column(name = "psg_name")
    val name: String

)
