package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toEntity
import br.com.ezequiel.travels.service.driver.mapper.toModel
import br.com.ezequiel.travels.service.driver.model.DriverToCreate
import org.springframework.stereotype.Service

@Service
class CreateDriverService(private val driverRepository: DriverRepository) {

    fun execute(driverToCreate: DriverToCreate) = driverRepository.save(driverToCreate.toEntity()).toModel()

}