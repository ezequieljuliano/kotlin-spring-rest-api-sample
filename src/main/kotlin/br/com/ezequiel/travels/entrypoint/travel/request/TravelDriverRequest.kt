package br.com.ezequiel.travels.entrypoint.travel.request

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class TravelDriverRequest(

    @field:Schema(description = "Driver identifier")
    val driverId: UUID

)
