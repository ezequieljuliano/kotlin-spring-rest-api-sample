package br.com.ezequiel.travels.component

import br.com.ezequiel.travels.repository.DriverRepository
import br.com.ezequiel.travels.repository.PassengerRepository
import br.com.ezequiel.travels.repository.TravelRepository
import br.com.ezequiel.travels.repository.entity.DriverEntity
import br.com.ezequiel.travels.repository.entity.PassengerEntity
import br.com.ezequiel.travels.repository.entity.TravelEntity
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDate
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class TravelRequestControllerTest {

    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var travelRepository: TravelRepository

    @Autowired
    private lateinit var passengerRepository: PassengerRepository

    @Autowired
    private lateinit var driverRepository: DriverRepository

    @BeforeEach
    fun setup() {
        RestAssured.baseURI = "http://localhost:$port/travels-api"
        RestAssured.useRelaxedHTTPSValidation()
    }

    @AfterEach
    fun tearDown() {
        travelRepository.deleteAll()
    }

    @Test
    fun whenCreateTravelRequestThenReturnStatusCreatedAndResponseBody() {
        val passengerId = passengerRepository.save(PassengerEntity(UUID.randomUUID(), "Ezequiel")).id
        val createTravelRequestJson =
            """ {"origin":"maravilha","destination":"campinas","passengerId":"$passengerId"} """
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .body(createTravelRequestJson)
            .post("/travel-requests")
            .then()
            .statusCode(HttpStatus.CREATED.value())
            .body("id", CoreMatchers.notNullValue())
            .body("origin", CoreMatchers.equalTo("maravilha"))
            .body("destination", CoreMatchers.equalTo("campinas"))
            .body("passenger.id", CoreMatchers.notNullValue())
            .body("passenger.name", CoreMatchers.equalTo("Ezequiel"))
    }

    @Test
    fun whenAcceptTravelRequestThenReturnStatusNoContent() {
        val passengerEntity = passengerRepository.save(PassengerEntity(UUID.randomUUID(), "Jon Snow"))
        val travelEntity = TravelEntity(UUID.randomUUID(), "Origin", "Destination", passengerEntity)
        val travelId = travelRepository.save(travelEntity).id
        val driverId = driverRepository.save(DriverEntity(UUID.randomUUID(), "Ezequiel", LocalDate.ofEpochDay(0))).id
        val driverTravelRequestJson = """{"driverId":"$driverId"}"""
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .body(driverTravelRequestJson)
            .put("/travel-requests/$travelId/accept")
            .then()
            .statusCode(HttpStatus.NO_CONTENT.value())
    }

    @Test
    fun whenRefuseTravelRequestThenReturnStatusNoContent() {
        val passengerEntity = passengerRepository.save(PassengerEntity(UUID.randomUUID(), "Jon Snow"))
        val travelEntity = TravelEntity(UUID.randomUUID(), "Origin", "Destination", passengerEntity)
        val travelId = travelRepository.save(travelEntity).id
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .put("/travel-requests/$travelId/refuse")
            .then()
            .statusCode(HttpStatus.NO_CONTENT.value())
    }

    @Test
    fun whenListTravelRequestsThenReturnStatusOkAndResponseBody() {
        val passengerEntity = passengerRepository.save(PassengerEntity(UUID.randomUUID(), "Jon Snow"))
        val travelEntity = TravelEntity(UUID.randomUUID(), "Origin", "Destination", passengerEntity)
        travelRepository.save(travelEntity)
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .get("/travel-requests/available")
            .then()
            .statusCode(HttpStatus.OK.value())
            .body(CoreMatchers.notNullValue())
            .body("[0].id", CoreMatchers.notNullValue())
            .body("[0].origin", CoreMatchers.equalTo("Origin"))
            .body("[0].destination", CoreMatchers.equalTo("Destination"))
            .body("[0].passenger.id", CoreMatchers.notNullValue())
            .body("[0].passenger.name", CoreMatchers.equalTo("Jon Snow"))
    }

}