package br.com.ezequiel.travels.entrypoint.passenger

import br.com.ezequiel.travels.entrypoint.passenger.input.PassengerToCreateInput
import br.com.ezequiel.travels.entrypoint.passenger.input.PassengerToUpdateInput
import br.com.ezequiel.travels.entrypoint.passenger.mapper.toModel
import br.com.ezequiel.travels.entrypoint.passenger.mapper.toOutput
import br.com.ezequiel.travels.entrypoint.passenger.output.PassengerOutput
import br.com.ezequiel.travels.service.passenger.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
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
    private val listAllPassengersService: ListAllPassengersService,
    private val deletePassengerService: DeletePassengerService
) {

    @GetMapping
    @Operation(description = "List all available passengers")
    fun listPassengers(): List<PassengerOutput> =
        listAllPassengersService.execute().stream().map { it.toOutput() }.collect(Collectors.toList())

    @GetMapping("/{id}")
    @Operation(description = "Returns a passenger by id")
    fun getPassenger(@PathVariable("id") id: UUID) = getPassengerService.execute(id).toOutput()

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Create a new passenger")
    fun createPassenger(@Valid @RequestBody passengerToCreate: PassengerToCreateInput) =
        createPassengerService.execute(passengerToCreate.toModel()).toOutput()

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Update a passenger by id")
    fun updatePassenger(@PathVariable("id") id: UUID, @Valid @RequestBody passengerToUpdate: PassengerToUpdateInput) {
        fullUpdatePassengerService.execute(passengerToUpdate.toModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Delete a passenger by id")
    fun deletePassenger(@PathVariable("id") id: UUID) {
        deletePassengerService.execute(id)
    }

}