package lt.markmerkk.jtrainer.controllers

import com.vladsch.flexmark.ast.*
import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.parser.ParserEmulationProfile
import com.vladsch.flexmark.util.options.MutableDataSet
import lt.markmerkk.jtrainer.entities.MenuHeader
import lt.markmerkk.jtrainer.entities.SpoilerBlock
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
        options.setFrom(ParserEmulationProfile.GITHUB_DOC)
        options.set(Parser.EXTENSIONS, listOf(
                AnchorLinkExtension.create()
        ))

        val parser = Parser.builder(options).build()
        val renderer = HtmlRenderer.builder(options).build()
        val resource = ClassPathResource("/assets/$docName.md")
        val resourceInputStream = resource.inputStream
        val writer = StringWriter()
        IOUtils.copy(resourceInputStream, writer, "UTF-8")
        val htmlFromFile = writer.toString()

        val document: Document = parser.parse(htmlFromFile)
        val html = renderer.render(document)
        val headers = parseHeaders(document, 2)
        val codeBlocks = parseCodeBlocks(document)

        data.addObject("out", html)
        data.addObject("headers", headers)
        return data
    }

    /**
     * Parses out all headers
     * @param input document input
     * @param headerLevel level to parse out
     */
    fun parseCodeBlocks(
            input: Document
    ): List<SpoilerBlock> {
        val headers = mutableListOf<SpoilerBlock>()
        val visitor = NodeVisitor(
                VisitHandler(Code::class.java, object : Visitor<Code> {
                    override fun visit(node: Code) {
                        System.out.println("Code block: " + node)
                    }

                })
        )
        visitor.visitChildren(input)
        return headers
    }

    /**
     * Parses out all headers
     * @param input document input
     * @param headerLevel level to parse out
     */
    fun parseHeaders(
            input: Document,
            headerLevel: Int
    ): List<MenuHeader> {
        val headers = mutableListOf<MenuHeader>()
        val visitor = NodeVisitor(
                VisitHandler(Heading::class.java, object : Visitor<Heading> {
                    override fun visit(node: Heading) {
                        if (node.level == 2) {
                            headers.add(
                                    MenuHeader(
                                            node.anchorRefText,
                                            node.anchorRefId
                                    )
                            )
                        }
                    }

                })
        )
        visitor.visitChildren(input)
        return headers
    }

}