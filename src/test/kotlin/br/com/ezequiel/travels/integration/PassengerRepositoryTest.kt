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
        val passengerEntity = PassengerEntity(UUID.randomUUID(), "Jon Snow")

        // when
        val result = subject.save(passengerEntity)

        // then
        Assertions.assertEquals(passengerEntity.name, result.name)
    }

    @Test
    fun whenDeleteByIdPassengerThenSuccessfullyDeletePassenger() {
        // given
        val passengerEntity = PassengerEntity(UUID.randomUUID(), "Jon Snow")
        val passengerId = subject.save(passengerEntity).id

        // when
        subject.deleteById(passengerId)

        // then
        Assertions.assertFalse(subject.existsById(passengerId))
    }

    @Test
    fun whenGetByIdPassengerThenReturnPassenger() {
        // given
        val passengerEntity = PassengerEntity(UUID.randomUUID(), "Jon Snow")
        val passengerId = subject.save(passengerEntity).id

        // when
        val result = subject.getById(passengerId)

        // then
        Assertions.assertEquals(passengerId, result.id)
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