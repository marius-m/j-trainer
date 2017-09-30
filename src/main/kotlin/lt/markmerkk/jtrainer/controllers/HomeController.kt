package lt.markmerkk.jtrainer.controllers

import lt.markmerkk.jtrainer.services.MDToHtmlConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
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
    ): String {
        return "redirect:/" + (inputDoc ?: "index")
    }

    @RequestMapping(
            value = *arrayOf("/{document}"),
            method = arrayOf(RequestMethod.GET)
    )
    fun indexAsRoute(
            @PathVariable("document") document: String
    ): ModelAndView {
        val data = ModelAndView("index")
        val mdHtml = htmlConverter.toHtml(document)
        data.addObject("out", mdHtml.html)
        data.addObject("headers", mdHtml.headers)
        return data
    }

}