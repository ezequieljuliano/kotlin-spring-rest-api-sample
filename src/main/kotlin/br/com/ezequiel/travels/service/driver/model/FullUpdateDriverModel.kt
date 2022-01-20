package br.com.ezequiel.travels.service.driver.model

import java.time.LocalDate
import java.util.UUID

data class FullUpdateDriverModel(

    val id: UUID,
    val name: String,
    val birthdate: LocalDate

)
