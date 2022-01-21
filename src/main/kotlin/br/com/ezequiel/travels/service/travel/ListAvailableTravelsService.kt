package br.com.ezequiel.travels.service.travel

import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.TravelStatusEnum
import br.com.ezequiel.travels.service.travel.mapper.toModel
import br.com.ezequiel.travels.service.travel.model.Travel
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ListAvailableTravelsService(private val travelRepository: TravelRepository) {

    fun execute(): List<Travel> =
        travelRepository.findByStatus(TravelStatusEnum.CREATED).stream().map { it.toModel() }
            .collect(Collectors.toList())

}