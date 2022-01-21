package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toModel
import br.com.ezequiel.travels.service.driver.model.Driver
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ListAllDriversService(private val driverRepository: DriverRepository) {

    fun execute(): List<Driver> =
        driverRepository.findAll().stream().map { it.toModel() }.collect(Collectors.toList())

}