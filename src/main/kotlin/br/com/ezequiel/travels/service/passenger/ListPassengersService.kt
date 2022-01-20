package br.com.ezequiel.travels.service.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.service.passenger.mapper.toModel
import br.com.ezequiel.travels.service.passenger.model.SinglePassengerModel
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ListPassengersService(private val passengerRepository: PassengerRepository) {

    fun execute(): List<SinglePassengerModel> =
        passengerRepository.findAll().stream().map { it.toModel() }.collect(Collectors.toList())

}