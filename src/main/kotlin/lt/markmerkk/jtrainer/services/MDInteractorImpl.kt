package lt.markmerkk.jtrainer.services

import com.vladsch.flexmark.ast.*
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import lt.markmerkk.jtrainer.entities.MenuHeader
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ClassPathResource
import java.io.StringWriter

/**
 * @author mariusmerkevicius
 * @since 2017-09-29
 */
class MDInteractorImpl(
        private val parser: Parser,
        private val renderer: HtmlRenderer
) : MDInteractor {

    override fun mdFileExist(filePath: String): Boolean {
        val resource = ClassPathResource("/$PATH_PREFIX/$filePath.md")
        return resource.exists()
    }

    override fun mdFileAsString(filePath: String): String {
        val resource = ClassPathResource("/$PATH_PREFIX/$filePath.md")
        if (!resource.exists()) {
            return ""
        }
        val resourceInputStream = resource.inputStream
        val writer = StringWriter()
        IOUtils.copy(resourceInputStream, writer, "UTF-8")
        return writer.toString()
    }

    override fun mdToDocument(mdAsString: String): Document {
        return parser.parse(mdAsString)
    }

    override fun documentToHtml(document: Document): String {
        return renderer.render(document)
    }

    override fun parseHeadersWithLevel(document: Document, headerLevel: Int): List<MenuHeader> {
        val headers = mutableListOf<MenuHeader>()
        val visitor = NodeVisitor(
                VisitHandler(Heading::class.java, object : Visitor<Heading> {
                    override fun visit(node: Heading) {
                        if (node.level == headerLevel) {
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
        visitor.visitChildren(document)
        return headers
    }

    companion object {
        const val PATH_PREFIX = "assets"

    }

}