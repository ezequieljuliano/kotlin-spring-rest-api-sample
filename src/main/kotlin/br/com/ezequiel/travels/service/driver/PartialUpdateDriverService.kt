package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toModel
import br.com.ezequiel.travels.service.driver.model.SingleDriverModel
import br.com.ezequiel.travels.service.driver.model.PartialUpdateDriverModel
import org.springframework.stereotype.Service

@Service
class PartialUpdateDriverService(private val driverRepository: DriverRepository) {

    fun execute(driver: PartialUpdateDriverModel): SingleDriverModel {
        val foundDriver = driverRepository.getById(driver.id)
        val updateDriver = foundDriver.copy(
            name = driver.name ?: foundDriver.name,
            birthdate = driver.birthdate ?: foundDriver.birthdate,
        )
        return driverRepository.save(updateDriver).toModel()
    }

}