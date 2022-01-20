package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toModel
import br.com.ezequiel.travels.service.driver.model.SingleDriverModel
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ListDriversService(private val driverRepository: DriverRepository) {

    fun execute(): List<SingleDriverModel> =
        driverRepository.findAll().stream().map { it.toModel() }.collect(Collectors.toList())

}