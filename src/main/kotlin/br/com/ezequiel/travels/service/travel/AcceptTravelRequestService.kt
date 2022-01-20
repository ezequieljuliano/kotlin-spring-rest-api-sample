package br.com.ezequiel.travels.service.travel

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.TravelStatus
import br.com.ezequiel.travels.service.travel.mapper.toModel
import br.com.ezequiel.travels.service.travel.model.SingleTravelRequestModel
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AcceptTravelRequestService(
    private val travelRepository: TravelRepository,
    private val driverRepository: DriverRepository
) {

    fun execute(travelRequestId: UUID, driverId: UUID): SingleTravelRequestModel {
        val travel = travelRepository.getById(travelRequestId)
        val driver = driverRepository.getById(driverId)
        travel.status = TravelStatus.ACCEPTED
        travel.driver = driver
        travelRepository.save(travel)
        return travel.toModel()
    }

}