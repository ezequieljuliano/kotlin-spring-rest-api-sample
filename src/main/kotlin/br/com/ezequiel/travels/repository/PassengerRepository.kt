package br.com.ezequiel.travels.repository

import br.com.ezequiel.travels.repository.entity.PassengerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PassengerRepository : JpaRepository<PassengerEntity, UUID>