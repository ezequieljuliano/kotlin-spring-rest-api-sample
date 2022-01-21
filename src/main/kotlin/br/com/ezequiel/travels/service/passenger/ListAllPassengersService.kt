package br.com.ezequiel.travels.service.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.service.passenger.mapper.toModel
import br.com.ezequiel.travels.service.passenger.model.Passenger
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ListAllPassengersService(private val passengerRepository: PassengerRepository) {

    fun execute(): List<Passenger> =
        passengerRepository.findAll().stream().map { it.toModel() }.collect(Collectors.toList())

}