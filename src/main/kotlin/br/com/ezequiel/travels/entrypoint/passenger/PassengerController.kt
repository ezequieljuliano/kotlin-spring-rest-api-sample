package br.com.ezequiel.travels.entrypoint.passenger

import br.com.ezequiel.travels.entrypoint.passenger.request.PassengerToCreateRequest
import br.com.ezequiel.travels.entrypoint.passenger.request.PassengerToUpdateRequest
import br.com.ezequiel.travels.entrypoint.passenger.mapper.toModel
import br.com.ezequiel.travels.entrypoint.passenger.mapper.toOutput
import br.com.ezequiel.travels.entrypoint.passenger.response.PassengerResponse
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
@RequestMapping("/passengers")
@Tag(name = "Passengers API", description = "Manage passenger data")
class PassengerController(
    private val createPassengerService: CreatePassengerService,
    private val fullUpdatePassengerService: UpdatePassengerService,
    private val getPassengerService: GetPassengerService,
    private val listAllPassengersService: ListAllPassengersService,
    private val deletePassengerService: DeletePassengerService
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(description = "List all available passengers")
    fun listPassengers(): List<PassengerResponse> =
        listAllPassengersService.execute().stream().map { it.toOutput() }.collect(Collectors.toList())

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(description = "Returns a passenger by id")
    fun getPassenger(@PathVariable("id") id: UUID) = getPassengerService.execute(id).toOutput()

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Create a new passenger")
    fun createPassenger(@Valid @RequestBody passengerToCreate: PassengerToCreateRequest) =
        createPassengerService.execute(passengerToCreate.toModel()).toOutput()

    @PutMapping("/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Update a passenger by id")
    fun updatePassenger(@PathVariable("id") id: UUID, @Valid @RequestBody passengerToUpdate: PassengerToUpdateRequest) {
        fullUpdatePassengerService.execute(passengerToUpdate.toModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Delete a passenger by id")
    fun deletePassenger(@PathVariable("id") id: UUID) {
        deletePassengerService.execute(id)
    }

}