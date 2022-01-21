package br.com.ezequiel.travels.service.travel

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.TravelStatusEnum
import br.com.ezequiel.travels.service.travel.mapper.toModel
import br.com.ezequiel.travels.service.travel.model.Travel
import org.springframework.stereotype.Service
import java.util.*

@Service
class AcceptTravelService(
    private val travelRepository: TravelRepository,
    private val driverRepository: DriverRepository
) {

    fun execute(travelId: UUID, driverId: UUID): Travel {
        val travel = travelRepository.getById(travelId)
        val driver = driverRepository.getById(driverId)
        travel.status = TravelStatusEnum.ACCEPTED
        travel.driver = driver
        travelRepository.save(travel)
        return travel.toModel()
    }

}