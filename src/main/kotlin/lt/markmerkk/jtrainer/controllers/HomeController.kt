package lt.markmerkk.jtrainer.controllers

import lt.markmerkk.jtrainer.services.MDToHtmlConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


@Controller
class HomeController(
        private val htmlConverter: MDToHtmlConverter
) {

    @RequestMapping(
            value = *arrayOf("/"),
            method = arrayOf(RequestMethod.GET)
    )
    fun index(
            @RequestParam(required = false) inputDoc: String?
    ): ModelAndView {
        val data = ModelAndView("index")
        val mdHtml = htmlConverter.toHtml(inputDoc ?: "index")
        data.addObject("out", mdHtml.html)
        data.addObject("headers", mdHtml.headers)
        return data
    }


}