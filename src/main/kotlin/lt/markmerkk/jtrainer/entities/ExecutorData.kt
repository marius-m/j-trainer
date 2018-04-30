package lt.markmerkk.jtrainer.entities

import javax.persistence.*

@Entity
@Table(name = "executor", schema = "public")
data class ExecutorData(
        @Id @GeneratedValue val id: Long = -1,
        @Column(length = 50, unique = true) val uuid: String,
        @Column(columnDefinition = "TEXT") val source: String,
        @Column(columnDefinition = "TEXT") val output: String = ""
)