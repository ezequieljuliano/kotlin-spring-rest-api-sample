package br.com.ezequiel.travels.unity.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.repository.entity.DriverEntity
import br.com.ezequiel.travels.service.driver.CreateDriverService
import br.com.ezequiel.travels.service.driver.model.DriverToCreate
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.UUID

class CreateDriverServiceTest {

    private val driverRepository: DriverRepository = mockk(relaxed = true)
    private val subject = CreateDriverService(driverRepository)
    private val mockedDriver = DriverEntity(UUID.randomUUID(), "Jon Snow", LocalDate.MIN)

    @Test
    fun whenCreateDriverThenReturnCreatedDriver() {
        // given
        val newDriver = DriverToCreate(mockedDriver.name, mockedDriver.birthdate)
        every { driverRepository.save(any()) } returns mockedDriver

        // when
        val result = subject.execute(newDriver)

        // then
        Assertions.assertEquals(mockedDriver.id, result.id)
        Assertions.assertEquals(mockedDriver.name, result.name)
        Assertions.assertEquals(mockedDriver.birthdate, result.birthdate)
        verify(exactly = 1) { driverRepository.save(any()) }
    }


}