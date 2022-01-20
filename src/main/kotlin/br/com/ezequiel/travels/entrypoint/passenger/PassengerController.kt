package br.com.ezequiel.travels.entrypoint.passenger

import br.com.ezequiel.travels.entrypoint.passenger.input.CreatePassengerInput
import br.com.ezequiel.travels.entrypoint.passenger.input.UpdatePassengerInput
import br.com.ezequiel.travels.entrypoint.passenger.mapper.toModel
import br.com.ezequiel.travels.entrypoint.passenger.mapper.toOutput
import br.com.ezequiel.travels.entrypoint.passenger.output.SinglePassengerOutput
import br.com.ezequiel.travels.service.passenger.CreatePassengerService
import br.com.ezequiel.travels.service.passenger.DeletePassengerService
import br.com.ezequiel.travels.service.passenger.GetPassengerService
import br.com.ezequiel.travels.service.passenger.ListPassengersService
import br.com.ezequiel.travels.service.passenger.UpdatePassengerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors
import javax.validation.Valid

@RestController
@RequestMapping(
    path = ["/passengers"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
@Tag(name = "Passengers API", description = "Manage passenger data")
class PassengerController(
    private val createPassengerService: CreatePassengerService,
    private val fullUpdatePassengerService: UpdatePassengerService,
    private val getPassengerService: GetPassengerService,
    private val listPassengersService: ListPassengersService,
    private val deletePassengerService: DeletePassengerService
) {

    @GetMapping
    @Operation(description = "List all available passengers")
    fun listPassengers(): List<SinglePassengerOutput> =
        listPassengersService.execute().stream().map { it.toOutput() }.collect(Collectors.toList())

    @GetMapping("/{id}")
    @Operation(description = "Returns a passenger by id")
    fun getPassenger(@PathVariable("id") id: UUID) = getPassengerService.execute(id).toOutput()

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Create a new passenger")
    fun createPassenger(@Valid @RequestBody passenger: CreatePassengerInput) =
        createPassengerService.execute(passenger.toModel()).toOutput()

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Update a passenger by id")
    fun updatePassenger(@PathVariable("id") id: UUID, @Valid @RequestBody passenger: UpdatePassengerInput) {
        fullUpdatePassengerService.execute(passenger.toModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Delete a passenger by id")
    fun deletePassenger(@PathVariable("id") id: UUID) {
        deletePassengerService.execute(id)
    }

}