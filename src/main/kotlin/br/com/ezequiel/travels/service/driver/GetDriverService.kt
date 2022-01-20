package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.mapper.toModel
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetDriverService(private val driverRepository: DriverRepository) {

    fun execute(driverId: UUID) = driverRepository.getById(driverId).toModel();

}