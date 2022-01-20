package br.com.ezequiel.travels.unity.passenger

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.service.passenger.DeletePassengerService
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.util.UUID

class DeletePassengerServiceTest {

    private val passengerRepository: PassengerRepository = mockk(relaxed = true)
    private val subject = DeletePassengerService(passengerRepository)
    private val passengerId = UUID.randomUUID()

    @Test
    fun whenDeletePassengerThenRunSuccessfullyWithoutExceptions() {
        // given
        every { passengerRepository.deleteById(passengerId) } just Runs

        // when
        subject.execute(passengerId)

        // then
        verify(exactly = 1) { passengerRepository.deleteById(passengerId) }
    }

}