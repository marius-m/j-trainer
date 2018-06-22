package lt.markmerkk.jtrainer.entities

import lt.markmerkk.jtrainer.components.ExerciseResult
import javax.persistence.*

@Entity
@Table(name = "executor", schema = "public")
data class ExecutorData(
        @Id @GeneratedValue val id: Long = -1,
        @Column(length = 50, unique = true) val uuid: String,
        @Column(columnDefinition = "TEXT") val source: String,
        @Column(columnDefinition = "TEXT") val output: String = ""
) {
    fun from(
            exerciseResult: ExerciseResult
    ): ExecutorData {
        return ExecutorData(
                id = id,
                uuid = uuid,
                source = source,
                output = exerciseResult.result
        )
    }
}