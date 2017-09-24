package lt.markmerkk.jtrainer.controllers

import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.options.MutableDataSet
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.io.StringWriter

@Controller
class HomeController {

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

        val options = MutableDataSet()
        val parser = Parser.builder(options).build()
        val renderer = HtmlRenderer.builder(options).build()
        val resource = ClassPathResource("/assets/$docName.md")
        val resourceInputStream = resource.inputStream
        val writer = StringWriter()
        IOUtils.copy(resourceInputStream, writer, "UTF-8")
        val htmlFromFile = writer.toString()

        val document = parser.parse(htmlFromFile)
        val html = renderer.render(document)

        data.addObject("out", html)
        return data
    }

}