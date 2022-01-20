package br.com.ezequiel.travels.service.travel

import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.TravelStatus
import br.com.ezequiel.travels.service.travel.mapper.toModel
import br.com.ezequiel.travels.service.travel.model.SingleTravelRequestModel
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RefuseTravelRequestService(private val travelRepository: TravelRepository) {

    fun execute(travelRequestId: UUID): SingleTravelRequestModel {
        val travel = travelRepository.getById(travelRequestId)
        travel.status = TravelStatus.REFUSED
        travelRepository.save(travel)
        return travel.toModel()
    }

}