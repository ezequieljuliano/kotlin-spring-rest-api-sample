package br.com.ezequiel.travels.entrypoint.travel

import br.com.ezequiel.travels.entrypoint.travel.request.TravelDriverRequest
import br.com.ezequiel.travels.entrypoint.travel.request.TravelToCreateRequest
import br.com.ezequiel.travels.entrypoint.travel.mapper.toModel
import br.com.ezequiel.travels.entrypoint.travel.mapper.toOutput
import br.com.ezequiel.travels.entrypoint.travel.response.TravelResponse
import br.com.ezequiel.travels.service.travel.AcceptTravelService
import br.com.ezequiel.travels.service.travel.CreateTravelService
import br.com.ezequiel.travels.service.travel.ListAvailableTravelsService
import br.com.ezequiel.travels.service.travel.RefuseTravelService
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
    path = ["/travel-requests"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
@Tag(name = "Travel Requests API", description = "Manage travel requests data")
class TravelRequestController(
    private val acceptTravelService: AcceptTravelService,
    private val createTravelService: CreateTravelService,
    private val listAvailableTravelsService: ListAvailableTravelsService,
    private val refuseTravelService: RefuseTravelService
) {

    @GetMapping("/available")
    @Operation(description = "List all available travel requests")
    fun listAvailableTravels(): List<TravelResponse> =
        listAvailableTravelsService.execute().stream().map { it.toOutput() }.collect(Collectors.toList())

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Create a new travel request")
    fun createTravelRequest(@Valid @RequestBody travelToCreate: TravelToCreateRequest) =
        createTravelService.execute(travelToCreate.toModel()).toOutput()

    @PutMapping("/{id}/accept")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Driver accept a travel request")
    fun acceptTravelRequest(@PathVariable("id") id: UUID, @Valid @RequestBody travelDriver: TravelDriverRequest) {
        acceptTravelService.execute(id, travelDriver.driverId)
    }

    @PutMapping("/{id}/refuse")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Refuse a travel request")
    fun refuseTravelRequest(@PathVariable("id") id: UUID) {
        refuseTravelService.execute(id)
    }

}