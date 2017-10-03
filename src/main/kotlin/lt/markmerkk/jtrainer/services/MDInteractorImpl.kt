package lt.markmerkk.jtrainer.services

import com.vladsch.flexmark.ast.*
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import lt.markmerkk.jtrainer.entities.MenuHeader
import lt.markmerkk.jtrainer.services.utils.HtmlRelativeLinkParser
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ClassPathResource
import java.io.StringWriter


/**
 * @author mariusmerkevicius
 * @since 2017-09-29
 */
class MDInteractorImpl(
        private val parser: Parser,
        private val renderer: HtmlRenderer,
        private val htmlRelativeLinkParser: HtmlRelativeLinkParser
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
        val document = parser.parse(mdAsString)
        return document
    }

    override fun documentToHtml(document: Document): String {
        var documentAsString = renderer.render(document)
        documentAsString = htmlRelativeLinkParser.sanitizeImageSourcePaths(documentAsString)
        documentAsString = htmlRelativeLinkParser.sanitizeHrefSourcePaths(documentAsString)
        return documentAsString
    }

    override fun parseHeadersWithLevel(document: Document, headerLevel: Int): List<MenuHeader> {
        val headers = mutableListOf<MenuHeader>()
        val visitor = NodeVisitor(
                VisitHandler(Heading::class.java, Visitor<Heading> { node ->
                    if (node.level == headerLevel) {
                        headers.add(
                                MenuHeader(
                                        node.anchorRefText,
                                        node.anchorRefId
                                )
                        )
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