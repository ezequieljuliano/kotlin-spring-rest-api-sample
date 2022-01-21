package br.com.ezequiel.travels.unity.driver

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.repository.entity.DriverEntity
import br.com.ezequiel.travels.service.driver.ListAllDriversService
import br.com.ezequiel.travels.service.driver.model.Driver
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.UUID

class ListAllDriversServiceTest {

    private val driverRepository: DriverRepository = mockk(relaxed = true)
    private val subject = ListAllDriversService(driverRepository)
    private val mockedDrivers = List(2) {
        DriverEntity(UUID.randomUUID(), "Jon Snow", LocalDate.MIN)
        DriverEntity(UUID.randomUUID(), "Arya Stark", LocalDate.MAX)
    }

    @Test
    fun whenListDriversThenReturnDriversSuccessfully() {
        // given
        every { driverRepository.findAll() } returns mockedDrivers

        // when
        val result = subject.execute()

        // then
        Assertions.assertEquals(mockedDrivers.size, result.size)
        assertEquals(mockedDrivers[0], result[0])
        assertEquals(mockedDrivers[1], result[1])
        verify(exactly = 1) { driverRepository.findAll() }
    }

    private fun assertEquals(mockedDriver: DriverEntity, resultDriver: Driver) {
        Assertions.assertEquals(mockedDriver.id, resultDriver.id)
        Assertions.assertEquals(mockedDriver.name, resultDriver.name)
        Assertions.assertEquals(mockedDriver.birthdate, resultDriver.birthdate)
    }


}