package br.com.ezequiel.travels.integration

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.util.UUID

@DataJpaTest
@ActiveProfiles("test")
class PassengerRepositoryTest {

    @Autowired
    private lateinit var subject: PassengerRepository

    @AfterEach
    fun tearDown() {
        subject.deleteAll()
    }

    @Test
    fun whenSavePassengerThenReturnSavedPassenger() {
        // given
        val driverEntity = PassengerEntity(UUID.randomUUID(), "Jon Snow")

        // when
        val result = subject.save(driverEntity)

        // then
        Assertions.assertEquals(driverEntity.name, result.name)
    }

    @Test
    fun whenDeleteByIdPassengerThenSuccessfullyDeletePassenger() {
        // given
        val driverEntity = PassengerEntity(UUID.randomUUID(), "Jon Snow")
        val driverId = subject.save(driverEntity).id

        // when
        subject.deleteById(driverId)

        // then
        Assertions.assertFalse(subject.existsById(driverId))
    }

    @Test
    fun whenGetByIdPassengerThenReturnPassenger() {
        // given
        val driverEntity = PassengerEntity(UUID.randomUUID(), "Jon Snow")
        val driverId = subject.save(driverEntity).id

        // when
        val result = subject.getById(driverId)

        // then
        Assertions.assertEquals(driverId, result.id)
        Assertions.assertEquals("Jon Snow", result.name)
    }

    @Test
    fun whenFindAllPassengersThenReturnAllPassengers() {
        // given
        subject.save(PassengerEntity(UUID.randomUUID(), "Jon Snow"))
        subject.save(PassengerEntity(UUID.randomUUID(), "Arya Stark"))

        // when
        val result = subject.findAll()

        // then
        Assertions.assertEquals(2, result.size)
    }

}