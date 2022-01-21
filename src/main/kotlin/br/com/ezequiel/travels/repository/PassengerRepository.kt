package br.com.ezequiel.travels.repository

import br.com.ezequiel.travels.repository.entity.PassengerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PassengerRepository : JpaRepository<PassengerEntity, UUID>