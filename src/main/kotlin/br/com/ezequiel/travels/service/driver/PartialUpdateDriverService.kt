package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toModel
import br.com.ezequiel.travels.service.driver.model.Driver
import br.com.ezequiel.travels.service.driver.model.DriverToPartialUpdate
import org.springframework.stereotype.Service

@Service
class PartialUpdateDriverService(private val driverRepository: DriverRepository) {

    fun execute(driverToPartialUpdate: DriverToPartialUpdate): Driver {
        val foundDriver = driverRepository.getById(driverToPartialUpdate.id)
        val updateDriver = foundDriver.copy(
            name = driverToPartialUpdate.name ?: foundDriver.name,
            birthdate = driverToPartialUpdate.birthdate ?: foundDriver.birthdate,
        )
        return driverRepository.save(updateDriver).toModel()
    }

}