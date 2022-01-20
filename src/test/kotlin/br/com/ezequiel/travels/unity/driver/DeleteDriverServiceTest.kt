package br.com.ezequiel.travels.unity.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.service.driver.DeleteDriverService
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.util.UUID

class DeleteDriverServiceTest {

    private val driverRepository: DriverRepository = mockk(relaxed = true)
    private val subject = DeleteDriverService(driverRepository)
    private val driverId = UUID.randomUUID()

    @Test
    fun whenDeleteDriverThenRunSuccessfullyWithoutExceptions() {
        // given
        every { driverRepository.deleteById(driverId) } just Runs

        // when
        subject.execute(driverId)

        // then
        verify(exactly = 1) { driverRepository.deleteById(driverId) }
    }


}