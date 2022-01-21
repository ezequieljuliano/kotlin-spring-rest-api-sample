package br.com.ezequiel.travels.service.travel

import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.TravelStatusEnum
import br.com.ezequiel.travels.service.travel.mapper.toModel
import br.com.ezequiel.travels.service.travel.model.Travel
import org.springframework.stereotype.Service
import java.util.*

@Service
class RefuseTravelService(private val travelRepository: TravelRepository) {

    fun execute(travelId: UUID): Travel {
        val travel = travelRepository.getById(travelId)
        travel.status = TravelStatusEnum.REFUSED
        travelRepository.save(travel)
        return travel.toModel()
    }

}