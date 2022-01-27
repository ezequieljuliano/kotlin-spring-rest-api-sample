package br.com.ezequiel.travels.repository.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "travel")
data class TravelEntity(

    @field:Id
    @field:GeneratedValue
    @field:Column(columnDefinition = "uuid", name = "trv_id", updatable = false)
    val id: UUID?,

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Column(name = "trv_origin")
    val origin: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 255)
    @field:Column(name = "trv_destination")
    val destination: String,

    @field:Valid
    @field:NotNull
    @field:ManyToOne
    @field:JoinColumn(name = "trv_psg_id", referencedColumnName = "psg_id")
    val passenger: PassengerEntity,

    @field:Valid
    @field:ManyToOne
    @field:JoinColumn(name = "trv_drv_id", referencedColumnName = "drv_id")
    var driver: DriverEntity? = null,

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    @field:Column(name = "trv_status")
    var status: TravelStatusEnum = TravelStatusEnum.CREATED,

    @field:NotNull
    @field:Column(name = "trv_created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()

)