package br.com.ezequiel.travels.unity.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.service.passenger.ListPassengersService
import br.com.ezequiel.travels.service.passenger.model.SinglePassengerModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID

class ListPassengersServiceTest {

    private val passengerRepository: PassengerRepository = mockk(relaxed = true)
    private val subject = ListPassengersService(passengerRepository)
    private val mockedPassengers = List(2) {
        PassengerEntity(UUID.randomUUID(), "Jon Snow")
        PassengerEntity(UUID.randomUUID(), "Arya Stark")
    }

    @Test
    fun whenListPassengersThenReturnPassengersSuccessfully() {
        // given
        every { passengerRepository.findAll() } returns mockedPassengers

        // when
        val result = subject.execute()

        // then
        Assertions.assertEquals(mockedPassengers.size, result.size)
        assertEquals(mockedPassengers[0], result[0])
        assertEquals(mockedPassengers[1], result[1])
        verify(exactly = 1) { passengerRepository.findAll() }
    }

    private fun assertEquals(mockedPassenger: PassengerEntity, resultPassenger: SinglePassengerModel) {
        Assertions.assertEquals(mockedPassenger.id, resultPassenger.id)
        Assertions.assertEquals(mockedPassenger.name, resultPassenger.name)
    }


}