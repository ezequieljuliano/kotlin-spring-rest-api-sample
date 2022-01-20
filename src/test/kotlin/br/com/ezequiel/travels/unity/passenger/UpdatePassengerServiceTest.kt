package br.com.ezequiel.travels.unity.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.service.passenger.UpdatePassengerService
import br.com.ezequiel.travels.service.passenger.model.UpdatePassengerModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID

class UpdatePassengerServiceTest {

    private val passengerRepository: PassengerRepository = mockk(relaxed = true)
    private val subject = UpdatePassengerService(passengerRepository)
    private val oldMockedPassenger = PassengerEntity(UUID.randomUUID(), "Jon Snow")
    private val updatedMockPassenger = PassengerEntity(oldMockedPassenger.id, "Arya Stark")

    @Test
    fun whenFullUpdatePassengerThenReturnUpdatedPassenger() {
        // given
        val updatedPassenger = UpdatePassengerModel(updatedMockPassenger.id, updatedMockPassenger.name)
        every { passengerRepository.getById(oldMockedPassenger.id) } returns oldMockedPassenger
        every { passengerRepository.save(any()) } returns updatedMockPassenger

        // when
        val result = subject.execute(updatedPassenger)

        // then
        Assertions.assertEquals(updatedMockPassenger.id, result.id)
        Assertions.assertEquals(updatedMockPassenger.name, result.name)
        verify(exactly = 1) { passengerRepository.getById(oldMockedPassenger.id) }
        verify(exactly = 1) { passengerRepository.save(any()) }
    }


}