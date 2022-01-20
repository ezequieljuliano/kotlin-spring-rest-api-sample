package br.com.ezequiel.travels.repository

import br.com.ezequiel.travels.repository.entity.DriverEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DriverRepository : JpaRepository<DriverEntity, UUID>