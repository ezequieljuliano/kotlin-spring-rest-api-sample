package br.com.ezequiel.travels.service.driver.model

import java.time.LocalDate
import java.util.UUID

data class SingleDriverModel(

    val id: UUID,
    val name: String,
    val birthdate: LocalDate

)