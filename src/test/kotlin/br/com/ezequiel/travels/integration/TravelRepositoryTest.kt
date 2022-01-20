package br.com.ezequiel.travels.integration

import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.util.UUID

@DataJpaTest
@ActiveProfiles("test")
class TravelRepositoryTest {

    @Autowired
    private lateinit var passengerRepository: PassengerRepository

    @Autowired
    private lateinit var subject: TravelRepository

    @AfterEach
    fun tearDown() {
        subject.deleteAll()
    }

    @Test
    fun whenSaveTravelThenReturnSavedTravel() {
        // given
        val passengerEntity = passengerRepository.save(PassengerEntity(UUID.randomUUID(), "Jon Snow"))
        val travelEntity = TravelEntity(UUID.randomUUID(), "Origin", "Destination", passengerEntity)

        // when
        val result = subject.save(travelEntity)

        // then
        Assertions.assertEquals(travelEntity.origin, result.origin)
        Assertions.assertEquals(travelEntity.destination, result.destination)
        Assertions.assertEquals(travelEntity.passenger.id, result.passenger.id)
    }

    @Test
    fun whenGetByIdTravelThenReturnTravel() {
        // given
        val passengerEntity = passengerRepository.save(PassengerEntity(UUID.randomUUID(), "Jon Snow"))
        val travelEntity = TravelEntity(UUID.randomUUID(), "Origin", "Destination", passengerEntity)
        val travelId = subject.save(travelEntity).id

        // when
        val result = subject.getById(travelId)

        // then
        Assertions.assertEquals(travelId, result.id)
        Assertions.assertEquals("Origin", result.origin)
        Assertions.assertEquals("Destination", result.destination)
        Assertions.assertEquals(passengerEntity.id, result.passenger.id)
    }

    @Test
    fun whenFindTravelsByStatusThenReturnTravelsList() {
        // given
        val passengerEntity = passengerRepository.save(PassengerEntity(UUID.randomUUID(), "Jon Snow"))
        subject.save(TravelEntity(UUID.randomUUID(), "Origin1", "Destination1", passengerEntity))
        subject.save(TravelEntity(UUID.randomUUID(), "Origin2", "Destination2", passengerEntity))

        // when
        val result = subject.findAll()

        // then
        Assertions.assertEquals(2, result.size)
    }

}