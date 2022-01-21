package br.com.ezequiel.travels.repository

import br.com.ezequiel.travels.repository.entity.TravelEntity
import br.com.ezequiel.travels.repository.entity.TravelStatusEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TravelRepository : JpaRepository<TravelEntity, UUID> {

    fun findByStatus(status: TravelStatusEnum): List<TravelEntity>

}