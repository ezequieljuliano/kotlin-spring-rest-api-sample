package br.com.ezequiel.travels.unity.travel

import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.repository.entity.TravelStatus
import br.com.ezequiel.travels.service.travel.ListAvailableTravelsService
import br.com.ezequiel.travels.service.travel.model.SingleTravelRequestModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID

class ListAvailableTravelsServiceTest {

    private val travelRepository: TravelRepository = mockk(relaxed = true)
    private val subject = ListAvailableTravelsService(travelRepository)
    private val mockedPassenger = PassengerEntity(UUID.randomUUID(), "Ezequiel")
    private val mockedTravels = List(2) {
        TravelEntity(UUID.randomUUID(), "Origin1", "Destination1", mockedPassenger)
        TravelEntity(UUID.randomUUID(), "Origin2", "Destination2", mockedPassenger)
    }

    @Test
    fun whenListAvailableTravelsThenReturnListSuccessfully() {
        // given
        every { travelRepository.findByStatus(TravelStatus.CREATED) } returns mockedTravels

        // when
        val result = subject.execute()

        // then
        Assertions.assertEquals(mockedTravels.size, result.size)
        assertEquals(mockedTravels[0], result[0])
        assertEquals(mockedTravels[1], result[1])
        verify(exactly = 1) { travelRepository.findByStatus(TravelStatus.CREATED) }
    }

    private fun assertEquals(mockedTravel: TravelEntity, resultTravel: SingleTravelRequestModel) {
        Assertions.assertEquals(mockedTravel.id, resultTravel.id)
        Assertions.assertEquals(mockedTravel.origin, resultTravel.origin)
        Assertions.assertEquals(mockedTravel.destination, resultTravel.destination)
        Assertions.assertEquals(mockedTravel.passenger.id, resultTravel.passenger.id)
        Assertions.assertEquals(mockedTravel.driver?.id, resultTravel.driver?.id)
        Assertions.assertEquals(TravelStatus.CREATED, resultTravel.status)
    }

}