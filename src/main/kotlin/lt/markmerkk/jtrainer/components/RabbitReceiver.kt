package lt.markmerkk.jtrainer.components

import lt.markmerkk.jtrainer.services.ExecutorRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitReceiver(
        val executorRepository: ExecutorRepository
) {
    @RabbitListener(queues = arrayOf("results"))
    fun receiveMessage(exerciseResult: ExerciseResult) {
        println("Received results $exerciseResult")
        val exercise = executorRepository.findByUuid(exerciseResult.uuid)
        if (exercise != null) {
            executorRepository.save(exercise.from(exerciseResult))
        }
    }
}

data class ExerciseResult @JvmOverloads constructor(
        var uuid: String = "",
        var success: Boolean = false,
        var result: String = ""
)
