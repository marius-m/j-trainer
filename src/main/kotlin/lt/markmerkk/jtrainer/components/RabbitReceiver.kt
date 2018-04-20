package lt.markmerkk.jtrainer.components

import org.springframework.stereotype.Component


@Component
class RabbitReceiver {

    fun receiveMessage(message: String) {
        println("Received <$message>")
    }

}