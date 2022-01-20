package br.com.ezequiel.travels.service.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeletePassengerService(private val passengerRepository: PassengerRepository) {

    fun execute(passengerId: UUID): Unit = passengerRepository.deleteById(passengerId)

}