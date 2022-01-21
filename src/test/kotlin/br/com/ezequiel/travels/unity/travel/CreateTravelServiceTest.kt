package br.com.ezequiel.travels.unity.travel

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.service.travel.CreateTravelService
import br.com.ezequiel.travels.service.travel.model.TravelToCreate
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID

class CreateTravelServiceTest {

    private val travelRepository: TravelRepository = mockk(relaxed = true)
    private val passengerRepository: PassengerRepository = mockk(relaxed = true)
    private val subject = CreateTravelService(travelRepository, passengerRepository)
    private val mockedPassenger = PassengerEntity(UUID.randomUUID(), "Ezequiel")
    private val mockedTravel = TravelEntity(UUID.randomUUID(), "Origin", "Destination", mockedPassenger)

    @Test
    fun whenCreateTravelRequestThenReturnCreatedTravel() {
        // given
        val newTravel = TravelToCreate(
            mockedTravel.origin, mockedTravel.destination, mockedTravel.passenger.id
        )
        every { passengerRepository.getById(any()) } returns mockedPassenger
        every { travelRepository.save(any()) } returns mockedTravel

        // when
        val result = subject.execute(newTravel)

        // then
        Assertions.assertEquals(mockedTravel.id, result.id)
        Assertions.assertEquals(mockedTravel.origin, result.origin)
        Assertions.assertEquals(mockedTravel.destination, result.destination)
        Assertions.assertEquals(mockedTravel.passenger.id, result.passenger.id)
        verify(exactly = 1) { travelRepository.save(any()) }
        verify(exactly = 1) { passengerRepository.getById(any()) }
    }

}