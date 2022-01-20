package br.com.ezequiel.travels.repository

import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.repository.entity.TravelStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TravelRepository : JpaRepository<TravelEntity, UUID> {

    fun findByStatus(status: TravelStatus): List<TravelEntity>

}