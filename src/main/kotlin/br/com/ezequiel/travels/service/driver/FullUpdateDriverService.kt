package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toModel
import br.com.ezequiel.travels.service.driver.model.Driver
import br.com.ezequiel.travels.service.driver.model.DriverToFullUpdate
import org.springframework.stereotype.Service

@Service
class FullUpdateDriverService(private val driverRepository: DriverRepository) {

    fun execute(driverToFullUpdate: DriverToFullUpdate): Driver {
        val foundDriver = driverRepository.getById(driverToFullUpdate.id)
        val updateDriver = foundDriver.copy(
            name = driverToFullUpdate.name,
            birthdate = driverToFullUpdate.birthdate,
        )
        return driverRepository.save(updateDriver).toModel()
    }

}