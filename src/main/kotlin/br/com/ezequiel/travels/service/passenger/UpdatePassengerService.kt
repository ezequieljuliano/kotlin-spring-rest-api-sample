package br.com.ezequiel.travels.service.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.service.passenger.mapper.toModel
import br.com.ezequiel.travels.service.passenger.model.Passenger
import br.com.ezequiel.travels.service.passenger.model.PassengerToUpdate
import org.springframework.stereotype.Service

@Service
class UpdatePassengerService(private val passengerRepository: PassengerRepository) {

    fun execute(passengerToUpdate: PassengerToUpdate): Passenger {
        val foundPassenger = passengerRepository.getById(passengerToUpdate.id)
        val updatePassenger = foundPassenger.copy(name = passengerToUpdate.name)
        return passengerRepository.save(updatePassenger).toModel()
    }

}