package br.com.ezequiel.travels.entrypoint.travel

import br.com.ezequiel.travels.entrypoint.travel.input.CreateTravelRequestInput
import br.com.ezequiel.travels.entrypoint.travel.input.DriverTravelRequestInput
import br.com.ezequiel.travels.entrypoint.travel.mapper.toModel
import br.com.ezequiel.travels.entrypoint.travel.mapper.toOutput
import br.com.ezequiel.travels.entrypoint.travel.output.SingleTravelRequestOutput
import br.com.ezequiel.travels.service.travel.AcceptTravelRequestService
import br.com.ezequiel.travels.service.travel.CreateTravelRequestService
import br.com.ezequiel.travels.service.travel.ListAvailableTravelsService
import br.com.ezequiel.travels.service.travel.RefuseTravelRequestService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
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
    path = ["/travel-requests"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
@Tag(name = "Travel Requests API", description = "Manage travel requests data")
class TravelRequestController(
    private val acceptTravelRequestService: AcceptTravelRequestService,
    private val createTravelRequestService: CreateTravelRequestService,
    private val listAvailableTravelsService: ListAvailableTravelsService,
    private val refuseTravelRequestService: RefuseTravelRequestService
) {

    @GetMapping("/available")
    @Operation(description = "List all available travel requests")
    fun listAvailableTravels(): List<SingleTravelRequestOutput> =
        listAvailableTravelsService.execute().stream().map { it.toOutput() }.collect(Collectors.toList())

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Create a new travel request")
    fun createTravelRequest(@Valid @RequestBody travelRequest: CreateTravelRequestInput) =
        createTravelRequestService.execute(travelRequest.toModel()).toOutput()

    @PutMapping("/{id}/accept")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Driver accept a travel request")
    fun acceptTravelRequest(@PathVariable("id") id: UUID, @Valid @RequestBody driver: DriverTravelRequestInput) {
        acceptTravelRequestService.execute(id, driver.driverId)
    }

    @PutMapping("/{id}/refuse")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Refuse a travel request")
    fun refuseTravelRequest(@PathVariable("id") id: UUID) {
        refuseTravelRequestService.execute(id)
    }

}