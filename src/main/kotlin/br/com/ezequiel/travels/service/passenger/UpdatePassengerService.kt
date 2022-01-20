package br.com.ezequiel.travels.service.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.service.passenger.mapper.toModel
import br.com.ezequiel.travels.service.passenger.model.SinglePassengerModel
import br.com.ezequiel.travels.service.passenger.model.UpdatePassengerModel
import org.springframework.stereotype.Service

@Service
class UpdatePassengerService(private val passengerRepository: PassengerRepository) {

    fun execute(passenger: UpdatePassengerModel): SinglePassengerModel {
        val foundPassenger = passengerRepository.getById(passenger.id)
        val updatePassenger = foundPassenger.copy(name = passenger.name)
        return passengerRepository.save(updatePassenger).toModel()
    }

}