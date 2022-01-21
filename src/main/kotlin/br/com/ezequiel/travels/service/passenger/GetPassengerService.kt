package br.com.ezequiel.travels.service.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.service.passenger.mapper.toModel
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetPassengerService(private val passengerRepository: PassengerRepository) {

    fun execute(passengerId: UUID) = passengerRepository.getById(passengerId).toModel();

}