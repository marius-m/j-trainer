package lt.markmerkk.jtrainer.services

import lt.markmerkk.jtrainer.entities.ExecutorData
import org.springframework.data.jpa.repository.JpaRepository

interface ExecutorRepository : JpaRepository<ExecutorData, Long> {
    fun findByUuid(uuid: String): ExecutorData?
}