package br.com.ezequiel.travels.service.driver

import br.com.ezequiel.travels.repository.DriverRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeleteDriverService(private val driverRepository: DriverRepository) {

    fun execute(driverId: UUID): Unit = driverRepository.deleteById(driverId)

}