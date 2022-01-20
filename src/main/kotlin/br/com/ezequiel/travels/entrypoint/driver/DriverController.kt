package br.com.ezequiel.travels.entrypoint.driver

import br.com.ezequiel.travels.entrypoint.driver.input.CreateDriverInput
import br.com.ezequiel.travels.entrypoint.driver.input.FullUpdateDriverInput
import br.com.ezequiel.travels.entrypoint.driver.input.PartialUpdateDriverInput
import br.com.ezequiel.travels.entrypoint.driver.mapper.toModel
import br.com.ezequiel.travels.entrypoint.driver.mapper.toOutput
import br.com.ezequiel.travels.entrypoint.driver.output.SingleDriverOutput
import br.com.ezequiel.travels.service.driver.CreateDriverService
import br.com.ezequiel.travels.service.driver.DeleteDriverService
import br.com.ezequiel.travels.service.driver.FullUpdateDriverService
import br.com.ezequiel.travels.service.driver.GetDriverService
import br.com.ezequiel.travels.service.driver.ListDriversService
import br.com.ezequiel.travels.service.driver.PartialUpdateDriverService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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
    private val listDriversService: ListDriversService,
    private val deleteDriverService: DeleteDriverService
) {

    @GetMapping
    @Operation(description = "List all available drivers")
    fun listDrivers(): List<SingleDriverOutput> =
        listDriversService.execute().stream().map { it.toOutput() }.collect(Collectors.toList())

    @GetMapping("/{id}")
    @Operation(description = "Returns a driver by id")
    fun getDriver(@PathVariable("id") id: UUID) = getDriverService.execute(id).toOutput()

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Create a new driver")
    fun createDriver(@Valid @RequestBody driver: CreateDriverInput) =
        createDriverService.execute(driver.toModel()).toOutput()

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Update a driver by id")
    fun fullUpdateDriver(@PathVariable("id") id: UUID, @Valid @RequestBody driver: FullUpdateDriverInput) {
        fullUpdateDriverService.execute(driver.toModel(id))
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Partially update a driver by id")
    fun partialUpdateDriver(@PathVariable("id") id: UUID, @Valid @RequestBody driver: PartialUpdateDriverInput) {
        partialUpdateDriverService.execute(driver.toModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Delete a driver by id")
    fun deleteDriver(@PathVariable("id") id: UUID) {
        deleteDriverService.execute(id)
    }

}