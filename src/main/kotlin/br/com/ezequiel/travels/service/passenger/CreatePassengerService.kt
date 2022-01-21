package br.com.ezequiel.travels.service.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.service.passenger.mapper.toEntity
import br.com.ezequiel.travels.service.passenger.mapper.toModel
import br.com.ezequiel.travels.service.passenger.model.PassengerToCreate
import org.springframework.stereotype.Service

@Service
class CreatePassengerService(private val passengerRepository: PassengerRepository) {

    fun execute(passengerToCreate: PassengerToCreate) = passengerRepository.save(passengerToCreate.toEntity()).toModel()

}