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

        val docName = if (!inputDoc.isNullOrEmpty()) {
            inputDoc
        } else {
            "index"
        }

        val mdAsHtml = htmlConverter.toHtml(docName!!)
        data.addObject("out", mdAsHtml)
//        data.addObject("headers", headers)
        return data
    }


}