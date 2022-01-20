package br.com.ezequiel.travels.service.driver.model

import java.time.LocalDate

data class CreateDriverModel(

    val name: String,
    val birthdate: LocalDate

)
