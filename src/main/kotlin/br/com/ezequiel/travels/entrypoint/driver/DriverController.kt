package br.com.ezequiel.travels.entrypoint.driver

import br.com.ezequiel.travels.entrypoint.driver.input.DriverToCreateInput
import br.com.ezequiel.travels.entrypoint.driver.input.DriverToFullUpdateInput
import br.com.ezequiel.travels.entrypoint.driver.input.DriverToPartialUpdateInput
import br.com.ezequiel.travels.entrypoint.driver.mapper.toModel
import br.com.ezequiel.travels.entrypoint.driver.mapper.toOutput
import br.com.ezequiel.travels.entrypoint.driver.output.DriverOutput
import br.com.ezequiel.travels.service.driver.*
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
    path = ["/drivers"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
@Tag(name = "Drivers API", description = "Manage driver data")
class DriverController(
    private val createDriverService: CreateDriverService,
    private val fullUpdateDriverService: FullUpdateDriverService,
    private val partialUpdateDriverService: PartialUpdateDriverService,
    private val getDriverService: GetDriverService,
    private val listAllDriversService: ListAllDriversService,
    private val deleteDriverService: DeleteDriverService
) {

    @GetMapping
    @Operation(description = "List all available drivers")
    fun listDrivers(): List<DriverOutput> =
        listAllDriversService.execute().stream().map { it.toOutput() }.collect(Collectors.toList())

    @GetMapping("/{id}")
    @Operation(description = "Returns a driver by id")
    fun getDriver(@PathVariable("id") id: UUID) = getDriverService.execute(id).toOutput()

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Create a new driver")
    fun createDriver(@Valid @RequestBody driverToCreate: DriverToCreateInput) =
        createDriverService.execute(driverToCreate.toModel()).toOutput()

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Update a driver by id")
    fun fullUpdateDriver(@PathVariable("id") id: UUID, @Valid @RequestBody driverToFullUpdate: DriverToFullUpdateInput) {
        fullUpdateDriverService.execute(driverToFullUpdate.toModel(id))
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Partially update a driver by id")
    fun partialUpdateDriver(@PathVariable("id") id: UUID, @Valid @RequestBody driverToPartialUpdate: DriverToPartialUpdateInput) {
        partialUpdateDriverService.execute(driverToPartialUpdate.toModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Delete a driver by id")
    fun deleteDriver(@PathVariable("id") id: UUID) {
        deleteDriverService.execute(id)
    }

}