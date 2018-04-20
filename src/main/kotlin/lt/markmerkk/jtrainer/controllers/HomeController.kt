package lt.markmerkk.jtrainer.controllers

import lt.markmerkk.jtrainer.components.RabbitComponent
import lt.markmerkk.jtrainer.components.RabbitReceiver
import lt.markmerkk.jtrainer.custom_compiler.DynamicExecutor
import lt.markmerkk.jtrainer.entities.InputCode
import lt.markmerkk.jtrainer.entities.OutputCode
import lt.markmerkk.jtrainer.services.MDToHtmlConverter
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.util.concurrent.TimeUnit
import javax.servlet.http.HttpServletRequest


@Controller
class HomeController(
        private val htmlConverter: MDToHtmlConverter,
        private val dynamicExecutor: DynamicExecutor,
        private val rabbitTemplate: RabbitTemplate,
        private val rabbitReceiver: RabbitReceiver
) {

    @GetMapping(
            value = *arrayOf("/rabbit_run"),
            produces = arrayOf("application/json")
    )
    @ResponseBody fun testRabbit(): String {
        println("Sending message...")
        rabbitTemplate.convertAndSend(RabbitComponent.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!")
        return "{\"success\":1}"
    }

    @RequestMapping(
            value = *arrayOf("/"),
            method = arrayOf(RequestMethod.GET)
    )
    fun index(
            @RequestParam(required = false) inputDoc: String?
    ): String {
        return "redirect:/" + (inputDoc ?: "index")
    }

    @RequestMapping(
            value = *arrayOf("/{document}"),
            method = arrayOf(RequestMethod.GET)
    )
    fun indexAsRoute(
            request: HttpServletRequest,
            @PathVariable("document") document: String
    ): ModelAndView {
        println("ReqUrl: ${request.contextPath}")
        val data = ModelAndView("index")
        val mdHtml = htmlConverter.toHtml(document)
        if (!mdHtml.success) {
            return ModelAndView("redirect:/error")
        }
        data.addObject("out", mdHtml.html)
        data.addObject("headers", mdHtml.headers)
        return data
    }

    @RequestMapping(
            value = *arrayOf("/check"),
            method = arrayOf(RequestMethod.GET)
    )
    fun checkForm(model: Model): String {
        model.addAttribute("inputCode", InputCode())
        return "check"
    }

    @RequestMapping(
            value = *arrayOf("/check"),
            method = arrayOf(RequestMethod.POST)
    )
    fun checkSubmit(
            @ModelAttribute inputCode: InputCode
    ): ModelAndView {
        val data = ModelAndView("result")
        val outputCode = dynamicExecutor.execute(inputCode.injectCode)
        data.addObject("outputCode", outputCode)
        return data
    }

}