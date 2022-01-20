package br.com.ezequiel.travels.unity.travel

import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.repository.entity.TravelStatus
import br.com.ezequiel.travels.service.travel.RefuseTravelRequestService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID

class RefuseTravelRequestServiceTest {

    private val travelRepository: TravelRepository = mockk(relaxed = true)
    private val subject = RefuseTravelRequestService(travelRepository)
    private val mockedPassenger = PassengerEntity(UUID.randomUUID(), "Ezequiel")
    private val mockedTravel = TravelEntity(UUID.randomUUID(), "Origin", "Destination", mockedPassenger)

    @Test
    fun whenRefuseTravelRequestThenRunSuccessfullyWithoutExceptions() {
        // given
        every { travelRepository.getById(any()) } returns mockedTravel
        every { travelRepository.save(any()) } returns mockedTravel

        // when
        val result = subject.execute(UUID.randomUUID())

        // then
        Assertions.assertEquals(mockedTravel.id, result.id)
        Assertions.assertEquals(mockedTravel.origin, result.origin)
        Assertions.assertEquals(mockedTravel.destination, result.destination)
        Assertions.assertEquals(mockedTravel.passenger.id, result.passenger.id)
        Assertions.assertEquals(TravelStatus.REFUSED, result.status)
        verify(exactly = 1) { travelRepository.save(any()) }
        verify(exactly = 1) { travelRepository.getById(any()) }
    }

}