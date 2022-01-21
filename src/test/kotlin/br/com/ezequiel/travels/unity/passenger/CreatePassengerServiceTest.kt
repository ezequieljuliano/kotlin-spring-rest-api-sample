package br.com.ezequiel.travels.unity.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.service.passenger.CreatePassengerService
import br.com.ezequiel.travels.service.passenger.model.PassengerToCreate
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID

class CreatePassengerServiceTest {

    private val passengerRepository: PassengerRepository = mockk(relaxed = true)
    private val subject = CreatePassengerService(passengerRepository)
    private val mockedPassenger = PassengerEntity(UUID.randomUUID(), "Jon Snow")

    @Test
    fun whenCreatePassengerThenReturnCreatedPassenger() {
        // given
        val newPassenger = PassengerToCreate(mockedPassenger.name)
        every { passengerRepository.save(any()) } returns mockedPassenger

        // when
        val result = subject.execute(newPassenger)

        // then
        Assertions.assertEquals(mockedPassenger.id, result.id)
        Assertions.assertEquals(mockedPassenger.name, result.name)
        verify(exactly = 1) { passengerRepository.save(any()) }
    }

}