package lt.markmerkk.jtrainer.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ClassPathResource
import java.io.StringWriter
import org.springframework.context.support.ClassPathXmlApplicationContext

@Controller
class HomeController {

    @RequestMapping(
            value = *arrayOf("/"),
            method = arrayOf(RequestMethod.GET)
    )
    fun index(): String {
        return "index"
    }

    @RequestMapping(
            value = *arrayOf("/test"),
            method = arrayOf(RequestMethod.GET)
    )
    fun test(): ModelAndView {
        val data = ModelAndView()

        val options = MutableDataSet()

        val parser = Parser.builder(options).build()
        val renderer = HtmlRenderer.builder(options).build()

        // You can re-use parser and renderer instances
        val resource = ClassPathResource("/assets/help.md")
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