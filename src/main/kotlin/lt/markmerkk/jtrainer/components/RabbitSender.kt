package lt.markmerkk.jtrainer.components

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class RabbitSender(
        val rabbitTemplate: RabbitTemplate,
        val objectMapper: ObjectMapper
) {
    fun send(
            uuid: String,
            source: String
    ) {
//        val serialized = objectMapper.writeValueAsBytes(ExerciseSubmit(uuid, source))
        rabbitTemplate.convertAndSend(
                "execute",
                ExerciseSubmit(uuid, source)
        )
    }
}

data class ExerciseSubmit(
        val uuid: String,
        val source: String
)