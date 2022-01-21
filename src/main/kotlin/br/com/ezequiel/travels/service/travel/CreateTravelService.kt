package br.com.ezequiel.travels.service.travel

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.service.travel.mapper.toEntity
import br.com.ezequiel.travels.service.travel.mapper.toModel
import br.com.ezequiel.travels.service.travel.model.Travel
import br.com.ezequiel.travels.service.travel.model.TravelToCreate
import org.springframework.stereotype.Service

@Service
class CreateTravelService(
    private val travelRepository: TravelRepository,
    private val passengerRepository: PassengerRepository
) {

    fun execute(travelToCreate: TravelToCreate): Travel {
        val passenger = passengerRepository.getById(travelToCreate.passengerId)
        return travelRepository.save(travelToCreate.toEntity(passenger)).toModel()
    }

}