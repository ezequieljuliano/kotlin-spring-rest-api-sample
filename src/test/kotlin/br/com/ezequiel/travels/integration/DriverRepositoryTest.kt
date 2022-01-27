package br.com.ezequiel.travels.integration

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.repository.entity.DriverEntity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDate

@DataJpaTest
@ActiveProfiles("test")
class DriverRepositoryTest {

    @Autowired
    private lateinit var subject: DriverRepository

    @AfterEach
    fun tearDown() {
        subject.deleteAll()
    }

    @Test
    fun whenSaveDriverThenReturnSavedDriver() {
        // given
        val driverEntity = DriverEntity(null, "Jon Snow", LocalDate.MIN)

        // when
        val result = subject.save(driverEntity)

        // then
        Assertions.assertEquals(driverEntity.name, result.name)
        Assertions.assertEquals(driverEntity.birthdate, result.birthdate)
    }

    @Test
    fun whenDeleteByIdDriverThenSuccessfullyDeleteDriver() {
        // given
        val driverEntity = DriverEntity(null, "Jon Snow", LocalDate.MIN)
        val driverId = subject.save(driverEntity).id ?: throw RuntimeException("DriverId is null")

        // when
        subject.deleteById(driverId)

        // then
        Assertions.assertFalse(subject.existsById(driverId))
    }

    @Test
    fun whenGetByIdDriverThenReturnDriver() {
        // given
        val driverEntity = DriverEntity(null, "Jon Snow", LocalDate.MIN)
        val driverId = subject.save(driverEntity).id ?: throw RuntimeException("DriverId is null")

        // when
        val result = subject.getById(driverId)

        // then
        Assertions.assertEquals(driverId, result.id)
        Assertions.assertEquals("Jon Snow", result.name)
        Assertions.assertEquals(LocalDate.MIN, result.birthdate)
    }

    @Test
    fun whenFindAllDriversThenReturnAllDrivers() {
        subject.deleteAll()
        
        // given
        subject.save(DriverEntity(null, "Jon Snow", LocalDate.MIN))
        subject.save(DriverEntity(null, "Arya Stark", LocalDate.MIN))

        // when
        val result = subject.findAll()

        // then
        Assertions.assertEquals(2, result.size)
    }

}