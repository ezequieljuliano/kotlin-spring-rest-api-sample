package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toModel
import br.com.ezequiel.travels.service.driver.model.SingleDriverModel
import br.com.ezequiel.travels.service.driver.model.FullUpdateDriverModel
import org.springframework.stereotype.Service

@Service
class FullUpdateDriverService(private val driverRepository: DriverRepository) {

    fun execute(driver: FullUpdateDriverModel): SingleDriverModel {
        val foundDriver = driverRepository.getById(driver.id)
        val updateDriver = foundDriver.copy(
            name = driver.name,
            birthdate = driver.birthdate,
        )
        return driverRepository.save(updateDriver).toModel()
    }

}