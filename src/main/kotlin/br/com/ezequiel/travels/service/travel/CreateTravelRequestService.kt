package br.com.ezequiel.travels.service.travel

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.service.travel.mapper.toEntity
import br.com.ezequiel.travels.service.travel.mapper.toModel
import br.com.ezequiel.travels.service.travel.model.CreateTravelRequestModel
import br.com.ezequiel.travels.service.travel.model.SingleTravelRequestModel
import org.springframework.stereotype.Service

@Service
class CreateTravelRequestService(
    private val travelRepository: TravelRepository,
    private val passengerRepository: PassengerRepository
) {

    fun execute(travelRequest: CreateTravelRequestModel): SingleTravelRequestModel {
        val passenger = passengerRepository.getById(travelRequest.passengerId)
        return travelRepository.save(travelRequest.toEntity(passenger)).toModel()
    }

}