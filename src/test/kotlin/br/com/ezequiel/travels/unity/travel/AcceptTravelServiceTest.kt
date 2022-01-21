package br.com.ezequiel.travels.unity.travel

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.DriverEntity
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.repository.entity.TravelStatusEnum
import br.com.ezequiel.travels.service.travel.AcceptTravelService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.UUID

class AcceptTravelServiceTest {

    private val travelRepository: TravelRepository = mockk(relaxed = true)
    private val driverRepository: DriverRepository = mockk(relaxed = true)
    private val subject = AcceptTravelService(travelRepository, driverRepository)
    private val mockedPassenger = PassengerEntity(UUID.randomUUID(), "Ezequiel")
    private val mockedDriver = DriverEntity(UUID.randomUUID(), "Juliano", LocalDate.MIN)
    private val mockedTravel = TravelEntity(UUID.randomUUID(), "Origin", "Destination", mockedPassenger)

    @Test
    fun whenAcceptTravelRequestThenRunSuccessfullyWithoutExceptions() {
        // given
        every { driverRepository.getById(any()) } returns mockedDriver
        every { travelRepository.getById(any()) } returns mockedTravel
        every { travelRepository.save(any()) } returns mockedTravel

        // when
        val result = subject.execute(UUID.randomUUID(), UUID.randomUUID())

        // then
        Assertions.assertEquals(mockedTravel.id, result.id)
        Assertions.assertEquals(mockedTravel.origin, result.origin)
        Assertions.assertEquals(mockedTravel.destination, result.destination)
        Assertions.assertEquals(mockedTravel.passenger.id, result.passenger.id)
        Assertions.assertEquals(mockedTravel.driver?.id, result.driver?.id)
        Assertions.assertEquals(TravelStatusEnum.ACCEPTED, result.status)
        verify(exactly = 1) { travelRepository.save(any()) }
        verify(exactly = 1) { travelRepository.getById(any()) }
        verify(exactly = 1) { driverRepository.getById(any()) }
    }

}