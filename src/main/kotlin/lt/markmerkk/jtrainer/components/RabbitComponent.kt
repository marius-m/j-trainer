package lt.markmerkk.jtrainer.components

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
class RabbitComponent {

    @Bean
    fun connectionFactory(): ConnectionFactory {
        val connectionFactory = CachingConnectionFactory("namai")
        connectionFactory.username = "rabbitpi"
        connectionFactory.setPassword("rabberry")
        return connectionFactory
    }

    @Bean
    fun resultsQueue(): Queue {
        return Queue("results", false)
    }

    @Bean
    fun container(connectionFactory: ConnectionFactory, messageConverter: Jackson2JsonMessageConverter): SimpleMessageListenerContainer {
        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.setQueueNames("results")
        container.messageConverter = messageConverter
        return container
    }

    @Bean
    fun messageConverter(objectMapper: ObjectMapper): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter(objectMapper)
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
    }

}