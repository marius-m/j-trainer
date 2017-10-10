package lt.markmerkk.jtrainer.controllers

import lt.markmerkk.jtrainer.custom_compiler.DynamicExecutor
import lt.markmerkk.jtrainer.entities.InputCode
import lt.markmerkk.jtrainer.entities.OutputCode
import lt.markmerkk.jtrainer.services.MDToHtmlConverter
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.ModelAttribute


@Controller
class HomeController(
        private val htmlConverter: MDToHtmlConverter,
        private val dynamicExecutor: DynamicExecutor
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